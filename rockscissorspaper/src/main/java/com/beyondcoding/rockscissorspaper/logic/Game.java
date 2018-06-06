package com.beyondcoding.rockscissorspaper.logic;

import com.beyondcoding.rockscissorspaper.domain.Result;
import com.beyondcoding.rockscissorspaper.domain.shape.Shape;
import com.beyondcoding.rockscissorspaper.logic.judge.Judge;
import com.beyondcoding.rockscissorspaper.logic.player.Player;
import com.beyondcoding.rockscissorspaper.logic.player.Players;
import com.beyondcoding.rockscissorspaper.view.Host;

import java.util.List;

public class Game {

    private Judge judge = new Judge();

    public void play() {
        List<Player> players = Players.getTwoPlayers();
        Player player1 = players.get(0);
        Player player2 = players.get(1);

        Host.get().displayGreeting();
        play(player1, player2);
        Host.get().displayGoodbye();
    }

    private void play(Player player1, Player player2) {
        boolean playersWantToPlay = true;
        while (playersWantToPlay) {
            playOneRound(player1, player2);
            playersWantToPlay = ask(player1, player2);
        }
    }

    private void playOneRound(Player player1, Player player2) {
        Shape shape1 = player1.play();
        Shape shape2 = player2.play();
        Result result = judge.judge(shape1, shape2);
        Host.get().display(result);
    }

    private boolean ask(Player player1, Player player2) {
        return player1.wantsToPlayAgain() && player2.wantsToPlayAgain();
    }
}
