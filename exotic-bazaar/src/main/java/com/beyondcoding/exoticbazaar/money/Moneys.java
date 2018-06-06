package com.beyondcoding.exoticbazaar.money;

import com.beyondcoding.exoticbazaar.money.metal.Bronce;
import com.beyondcoding.exoticbazaar.money.metal.Gold;
import com.beyondcoding.exoticbazaar.money.metal.Silver;
import com.beyondcoding.exoticbazaar.money.preciousstone.Diamond;
import com.beyondcoding.exoticbazaar.money.preciousstone.Jade;
import com.beyondcoding.exoticbazaar.money.preciousstone.Sapphire;
import com.beyondcoding.exoticbazaar.money.seashell.BigSeaShell;
import com.beyondcoding.exoticbazaar.money.seashell.PearlShell;
import com.beyondcoding.exoticbazaar.money.seashell.SmallSeaShell;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Moneys {

    private static Set<Money> money = Stream.of(
            new PearlShell(), new BigSeaShell(), new SmallSeaShell(),
            new Diamond(), new Jade(), new Sapphire(),
            new Gold(), new Silver(), new Bronce()
    ).collect(Collectors.toSet());

    public static Set<Money> asSet() {
        return new HashSet<>(money);
    }

}
