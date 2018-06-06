package com.beyondcoding.rockscissorspaper.domain;

import com.beyondcoding.rockscissorspaper.domain.shape.Shape;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Result {

    private Shape shape1;

    private Shape shape2;

    private String winner;

}
