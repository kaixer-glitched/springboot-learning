package com.shootit.kobe;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @PutMapping("/{playerId}")
    public ResponseEntity<Player> updatePlayer(@PathVariable Long playerId, @Valid @RequestBody Player player) {
        // I just did a research, here's what I found:
        // Player updatedPlayer is not a new Player object since it does not create a new instance of Player with "new" keyword.

        Player updatedPlayer = playerServices.updatePlayer(playerId, player);
        // since the method updatePlayer returns null or a player, we can use that here
        // to check whether this updatedPlayer does really exist.
        // if not we will return a 404 using ResponseEntity.notFound().build();
        if (updatedPlayer == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updatedPlayer);
    }

    // more modern-solution
    @GetMapping("/{id}")
    public ResponseEntity<Player> searchPlayer(@PathVariable Long id) {
       return playerServices.getPlayerById(id)
               .map(ResponseEntity::ok)
               .orElse(ResponseEntity.notFound().build());
    }
}
