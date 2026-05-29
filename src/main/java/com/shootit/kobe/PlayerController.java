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
        // we will use Optional since we updated our playerServices update function
        // we will store the value that we got from the playerServices.updatePlayer() (after process)
        // we then will return the updatedPlayer back as a response
        // if the updatedPlayer has an actual value, then the map will unwrap ResponseEntity.ok for us
        // if it's a null, then give .notFound() / 404
        Optional<Player> updatedPlayer = playerServices.updatePlayer(playerId, player);

        return updatedPlayer
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // more modern-solution
    @GetMapping("/{id}")
    public ResponseEntity<Player> searchPlayer(@PathVariable Long id) {
        // a simpler approach
        /*
        Optional<Player> playerFound = playerServices.getPlayerById(id);

        if (playerFound.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(playerFound.get());
         */
        // advanced approach said by chat
       return playerServices.getPlayerById(id)
               .map(ResponseEntity::ok)
               .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Player> deletePlayer(@PathVariable Long id) {
        Optional<Player> updatedPlayer = playerServices.deletePlayer(id);

        // well yea this is cleaner lol
        return updatedPlayer
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
