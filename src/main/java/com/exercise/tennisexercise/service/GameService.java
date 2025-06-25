package com.exercise.tennisexercise.service;

import com.exercise.tennisexercise.entity.Game;
import com.exercise.tennisexercise.exception.GameNoEndException;
import com.exercise.tennisexercise.exception.ScoreDisplayException;
import com.exercise.tennisexercise.exception.GameInvalidInputException;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

@Service
@Log
public class GameService {

    public void runNewGame(String gameInput) throws ScoreDisplayException {

        if(gameInput == null || gameInput.isBlank()) {
            throw new GameNoEndException();
        }
        var game = new Game();

        for (int i = 0; i < gameInput.length(); i++) {
            char myChar = gameInput.charAt(i);
            if (myChar == 'A') {
                game.getPlayerA().score();
            } else if (myChar == 'B') {
                game.getPlayerB().score();
            } else throw new GameInvalidInputException();

            log.info(game.getGameScore());

            if (game.isGameFinished()) {
                return;
            }
        }
        throw new GameNoEndException();
    }
}
