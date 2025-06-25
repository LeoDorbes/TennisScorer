
package com.exercise.tennisexercise.entity;

import com.exercise.tennisexercise.exception.ScoreDisplayException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    void newGame_startsWithZeroScore() throws ScoreDisplayException {
        assertEquals(0, game.getPlayerA().getScore());
        assertEquals(0, game.getPlayerB().getScore());
        assertEquals("Player A : 0 / Player B : 0", game.getGameScore());
    }

    @Test
    void getGameScore_whenDeuce_returnsDeuce() throws ScoreDisplayException {
        game.getPlayerA().setScore(3);
        game.getPlayerB().setScore(3);
        assertEquals("Deuce", game.getGameScore());
    }

    @Test
    void getGameScore_whenAdvantagePlayerA_returnsCorrectScore() throws ScoreDisplayException {
        game.getPlayerA().setScore(4);
        game.getPlayerB().setScore(3);
        assertEquals("Player A : Advantage / Player B : 40", game.getGameScore());
    }

    @Test
    void getGameScore_whenAdvantagePlayerB_returnsCorrectScore() throws ScoreDisplayException {
        game.getPlayerA().setScore(3);
        game.getPlayerB().setScore(4);
        assertEquals("Player A : 40 / Player B : Advantage", game.getGameScore());
    }

    @Test
    void getGameScore_normalGameProgression_returnsCorrectScore() throws ScoreDisplayException {
        game.getPlayerA().setScore(1);
        game.getPlayerB().setScore(2);
        assertEquals("Player A : 15 / Player B : 30", game.getGameScore());
    }




    @Test
    void isGameFinished_whenPlayerWinsWithFourPoints_returnsTrue() {
        game.getPlayerA().setScore(4);
        game.getPlayerB().setScore(0);
        assertTrue(game.isGameFinished());
    }

    @Test
    void isGameFinished_whenScoreIsThreeThree_returnsFalse() {
        game.getPlayerA().setScore(3);
        game.getPlayerB().setScore(3);
        assertFalse(game.isGameFinished());
    }

    @Test
    void getGameScore_whenPlayerAWins_returnsPlayerAWinsMessage() throws ScoreDisplayException {
        game.getPlayerA().setScore(4);
        game.getPlayerB().setScore(0);
        assertEquals("Player A wins the game", game.getGameScore());
    }
}
