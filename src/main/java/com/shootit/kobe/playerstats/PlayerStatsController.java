package com.shootit.kobe.playerstats;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class PlayerStatsController {

    private final PlayerStatsServices playerStatsServices;
    public PlayerStatsController(PlayerStatsServices playerStatsServices) {
        this.playerStatsServices = playerStatsServices;
    }

    // just for saving stats sent by the user
    @PostMapping("/{playerId}/stats")
    public void saveStats(@PathVariable Long playerId, @Valid @RequestBody PlayerStats playerStats) {
        playerStatsServices.saveStats(playerId, playerStats);
    }

    // get a player's stats by given id
    @GetMapping("/{playerId}/stats")
    public ResponseEntity<PlayerStats> getStatsById(@PathVariable Long playerId) {
        return playerStatsServices.getStatsById(playerId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }
}
