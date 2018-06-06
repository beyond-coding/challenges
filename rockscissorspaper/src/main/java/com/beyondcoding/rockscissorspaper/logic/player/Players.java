package com.beyondcoding.rockscissorspaper.logic.player;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Players {

    private static Set<Player> players = Stream.of(
            new HumanPlayer(), new ComputerPlayer()
    ).collect(Collectors.toSet());

    private Players() {
    }

    public static List<Player> getTwoPlayers() {
        return players.stream().collect(Collectors.toList());
    }
}
