package com.shootit.kobe;

import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Getter
@Service
public class PlayerServices {
                                                // have no idea why I used ArrayList
    List<Player> players = new ArrayList<>();   // Claude said that I should use the interface then declare it as an ArrayList so that we can change it if we want.

    Long firstId = 1L;

    public List<Player> getAllPlayers() {
        return players;
    }

    public Player createPlayer(Player player) {
        player.setPlayerId(firstId);    // the first created player will receive the 1L declared at the top first.
        players.add(player);            // add player in the ArrayList of players
        firstId++;                      // memory id increment by 1 for each player created
        return player;                  // return a player object back to whoever calls it, good practice :D
    }
}
