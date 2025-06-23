package com.exercise.tenisexercise;

import com.exercise.tenisexercise.exception.ScoreDisplayException;
import com.exercise.tenisexercise.service.GameService;

public class TenisExerciseMain {

	public static void main(String[] args) {
		var scoreEngineService = new GameService();

        try {
            scoreEngineService.runNewGame("AABBABABABBBAAA");
        } catch (ScoreDisplayException e) {
            System.out.println("Error while processing the input string : invalid format, must contain A or B only");
        }

    }

}
