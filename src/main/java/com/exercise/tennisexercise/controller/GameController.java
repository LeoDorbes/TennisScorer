package com.exercise.tennisexercise.controller;

import com.exercise.tennisexercise.service.GameService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/game")
public class GameController {

    private final GameService gameService;

    @PostMapping("/play")
    public ResponseEntity<Void> playGame(@RequestBody String gameInput) {
        try {
            gameService.runNewGame(gameInput);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
