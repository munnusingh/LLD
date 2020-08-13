package com.game.battleship;

/**
 * BattleShipType is enum, based on the fact that battleship can be of 2 types P and Q having power 1 and 2 respectively.
 *
 * @author munnu
 */
public enum BattleShipType {
    P(1), Q(2);
    private final int power;

    BattleShipType(int power) {
        this.power = power;
    }

    public int getPower() {
        return power;
    }
}
