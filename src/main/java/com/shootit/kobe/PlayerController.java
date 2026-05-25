package com.shootit.kobe;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/players")
public class PlayerController {

    private final PlayerServices playerServices;
    public PlayerController(PlayerServices playerServices) {
        this.playerServices = playerServices;
    }

    @PostMapping
    public ResponseEntity<Player> createPlayer(@Valid @RequestBody Player player) {
        Player createdPlayer = playerServices.createPlayer(player);
        return ResponseEntity.ok(createdPlayer);
    }
}
