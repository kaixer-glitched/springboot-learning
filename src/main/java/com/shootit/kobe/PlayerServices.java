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
    public Player deletePlayer(Long id) {
        // .stream()
        Player playerToDelete = players.stream()
                .filter(p -> p.getPlayerId().equals(id))
                .findFirst()
                .orElse(null);

        if (playerToDelete == null) return null;
        players.remove(playerToDelete);
        return playerToDelete;
    }

    public Player updatePlayer(Long id, Player updatedPlayer) {
        // does this player first exist?
        // we use stream to do sets of actions for the data
        Player playerToUpdate = players.stream()
                .filter(p -> p.getPlayerId().equals(id))
                .findFirst()
                .orElse(null);

        if (playerToUpdate == null) return null;

        // playerToUpdate is still A PLAYER object, so it has the getters and setters from the PLAYER class
        // we can use the setters to set new information for this existing player
        // take the previous data from the OLD player via GETTERS
        // use the SETTERS to give this playerToUpdate object
        // playerToUpdate is a reference object created in this method as shown at the top
        // reference means it points to an old/existing object, rather than creating one a new
        // then just assign new data to him from the OLD one

        playerToUpdate.setPlayerName(updatedPlayer.getPlayerName());
        playerToUpdate.setJerseyNumber(updatedPlayer.getJerseyNumber());
        playerToUpdate.setAge(updatedPlayer.getAge());
        playerToUpdate.setYearsPro(updatedPlayer.getYearsPro());
        playerToUpdate.setPosition(updatedPlayer.getPosition());

        return  playerToUpdate;
    }

    // we will return a generic
    // Optional<Player> means we will promise a generic, but we cannot say that it is a player or null.
    public Optional<Player> getPlayerById(Long id) {
        return players.stream()
                .filter(p -> p.getPlayerId().equals(id))
                .findFirst();
    }
}
