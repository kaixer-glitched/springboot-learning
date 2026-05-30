package com.shootit.kobe.playerstats;

import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class PlayerStatsServices {

    private final Map<Long, PlayerStats> playerStatsMap =  new HashMap<Long, PlayerStats>();

    public void saveStats(Long playerId, PlayerStats playerStats) {
        playerStats.setId(playerId);
        playerStatsMap.put(playerId, playerStats);
    }

    public Optional<PlayerStats> getStatsById(Long playerId) {
        return Optional.ofNullable(playerStatsMap.get(playerId));
    }

    public Grade getGrade(int rating) {
        if (rating >= 96) return Grade.A_PLUS;
        if (rating >= 93) return Grade.A;
        if (rating >= 90) return Grade.A_MINUS;
        if (rating >= 86) return Grade.B_PLUS;
        if (rating >= 83) return Grade.B;
        if (rating >= 80) return Grade.B_MINUS;
        if (rating >= 76) return Grade.C_PLUS;
        if (rating >= 73) return Grade.C;
        if (rating >= 70) return Grade.C_MINUS;
        if (rating >= 66) return Grade.D_PLUS;
        if (rating >= 63) return Grade.D;
        if (rating >= 60) return Grade.D_MINUS;
        return Grade.F;
    }


}
