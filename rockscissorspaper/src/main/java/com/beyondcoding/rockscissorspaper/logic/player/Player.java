package com.beyondcoding.rockscissorspaper.logic.player;

import com.beyondcoding.rockscissorspaper.domain.shape.Shape;

public interface Player {

    Shape play();

    boolean wantsToPlayAgain();

}
