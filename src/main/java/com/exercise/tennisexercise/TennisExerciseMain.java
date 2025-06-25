package com.exercise.tennisexercise;

import com.exercise.tennisexercise.exception.ScoreDisplayException;
import com.exercise.tennisexercise.service.GameService;

public class TennisExerciseMain {

	public static void main(String[] args) {
		var scoreEngineService = new GameService();

        try {
            scoreEngineService.runNewGame("AABBABABABBBAAA");
        } catch (ScoreDisplayException e) {
            System.out.println("Error while processing the input string : invalid format, must contain A or B only");
        }

    }

}
