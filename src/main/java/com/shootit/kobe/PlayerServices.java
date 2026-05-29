package com.shootit.kobe;

import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
@Service
public class PlayerServices {
                                                // have no idea why I used ArrayList
    List<Player> players = new ArrayList<>();   // Claude said that I should use the interface then declare it as an ArrayList so that we can change it if we want.

    Long firstId = 1L;

    public List<Player> getAllPlayers() {
        return players;
    }

    // we don't need @NonNull as we can never receive null players due Jakarta validations and @Valid annotation in the controller.
    public Player createPlayer(Player player) {

        player.setPlayerId(firstId);    // the first created player will receive the 1L declared at the top first.
        players.add(player);            // add player in the ArrayList of players
        firstId++;                      // memory id increment by 1 for each player created
        return player;                  // return a player object back to whoever calls it, good practice :D
    }

    // we won't decrement the id cause it must stay the same regardless
    public Optional<Player> deletePlayer(Long id) {

        Optional<Player> player = players.stream()
               .filter(p -> p.getPlayerId().equals(id))
               .findFirst();

        // I prefer non-lambda style as of the moment
        if (player.isPresent()) {
            players.remove(player.orElseThrow());
        }
        return player;
    }
    // did a revamp for this block too lmao
    public Optional<Player> updatePlayer(Long id, Player updatedPlayer) {
        Optional<Player> playerToUpdate = players.stream()
                        .filter(p -> p.getPlayerId().equals(id))
                        .findFirst();

        // I don't need a return statement inside since regardless of value, we need to return the playerToUpdate
        if (playerToUpdate.isPresent()) {
            // create a player object then unwrap the value of <Optional> inside the Player object
            Player player = playerToUpdate.get();

            player.setPlayerName(updatedPlayer.getPlayerName());
            player.setJerseyNumber(updatedPlayer.getJerseyNumber());
            player.setAge(updatedPlayer.getAge());
            player.setYearsPro(updatedPlayer.getYearsPro());
            player.setPosition(updatedPlayer.getPosition());
        }
        return playerToUpdate;
    }

    // we will return a generic
    // Optional<Player> means we will promise a generic, but we cannot say that it is a player or null.
    public Optional<Player> getPlayerById(Long id) {
        return players.stream()
                .filter(p -> p.getPlayerId().equals(id))
                .findFirst();
    }
}
