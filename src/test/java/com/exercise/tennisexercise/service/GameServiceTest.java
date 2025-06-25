package com.exercise.tennisexercise.service;

import com.exercise.tennisexercise.exception.GameInvalidInputException;
import com.exercise.tennisexercise.exception.GameNoEndException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GameServiceTest {

    private GameService gameService;

    @BeforeEach
    void setUp() {
        gameService = new GameService();
    }

    @Test
    void runNewGame_withValidInput_processesGame() {
        assertDoesNotThrow(() -> gameService.runNewGame("AAAA"));
    }

    @Test
    void runNewGame_withInvalidInput_throwsException() {
        assertThrows(GameInvalidInputException.class, () -> gameService.runNewGame("AAZB"));
    }
    @Test
    void runNewGame_withPartialGameInput_processesGame() {
        assertThrows(GameNoEndException.class, () -> gameService.runNewGame("AABB"));
    }

    @Test
    void runNewGame_withEmptyInput_throwsException() {
        assertThrows(GameNoEndException.class, () -> gameService.runNewGame(""));
    }

    @Test
    void runNewGame_withNullInput_throwsException() {

        assertThrows(GameNoEndException.class, () -> gameService.runNewGame(null));
    }


}