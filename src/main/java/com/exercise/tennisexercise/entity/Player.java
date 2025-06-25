package com.exercise.tennisexercise.entity;

import com.exercise.tennisexercise.exception.ScoreDisplayException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;


@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Player {

    Integer score;
    String name;

    public String getRelativeScore(Integer otherPlayerScore) throws ScoreDisplayException {

        if (score <= 2) {
            return "Player " + name + " : " + score * 15;
        }
        if (score <= 3 || otherPlayerScore == score + 1) {
            return "Player " + name + " : 40";
        }

        if (otherPlayerScore + 1 == score) {
            return "Player " + name + " : Advantage";
        }

        throw new ScoreDisplayException();
    }

    public void score() {

        this.score++;
    }
}
