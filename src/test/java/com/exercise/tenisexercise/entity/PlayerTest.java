
package com.exercise.tenisexercise.entity;

import com.exercise.tenisexercise.exception.ScoreDisplayException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    private Player player;

    @BeforeEach
    void setUp() {
        player = new Player(0, "A");
    }

    @Test
    void whenPlayerScores_thenScoreIncrements() {
        assertEquals(0, player.getScore());
        player.score();
        assertEquals(1, player.getScore());
    }

    @Test
    void getRelativeScore_withValidScores_returnsCorrectScore() throws ScoreDisplayException {

        assertEquals("Player A : 0", player.getRelativeScore(0));

        player.score();
        assertEquals("Player A : 15", player.getRelativeScore(0));

        player.score();
        assertEquals("Player A : 30", player.getRelativeScore(0));

        player.score();
        assertEquals("Player A : 40", player.getRelativeScore(0));
    }

    @Test
    void getRelativeScore_whenAdvantage_returnsAdvantage() throws ScoreDisplayException {
        player.setScore(4);
        assertEquals("Player A : Advantage", player.getRelativeScore(3));

        player.setScore(500);
        assertEquals("Player A : Advantage", player.getRelativeScore(499));
    }

    @Test
    void getRelativeScore_withInvalidScore_throwsException() {
        player.setScore(5);
        assertThrows(ScoreDisplayException.class, () -> player.getRelativeScore(0));
    }
}