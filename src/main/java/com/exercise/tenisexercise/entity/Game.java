package com.exercise.tenisexercise.entity;

import com.exercise.tenisexercise.exception.ScoreDisplayException;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Objects;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Game {

    Player playerA;
    Player playerB;

    public Game() {

        this.playerA = new Player(0, "A");
        this.playerB = new Player(0, "B");
    }


    public String getGameScore() throws ScoreDisplayException {

        if (isGameFinished()) {
            if (playerA.getScore() > playerB.getScore()) {
                return "Player A wins the game";
            }
            return "Player B wins the game";
        }


        if (playerA.getScore() >= 3 && Objects.equals(playerA.getScore(), playerB.getScore())) {

            return "Deuce";
        }

        return playerA.getRelativeScore(playerB.getScore()) + " / " + playerB.getRelativeScore(playerA.getScore());
    }


    public Boolean isGameFinished() {

        var a = playerA.getScore();
        var b = playerB.getScore();

        if ((a >= 4 || b >= 4) && Math.abs(a - b) > 1) {
            return true;
        }

        return false;
    }

}
