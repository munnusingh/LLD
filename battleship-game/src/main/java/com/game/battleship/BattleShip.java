package com.game.battleship;

/**
 * This class BattleShip is subClass of Ship , which overrides createShip and getPower method based on the battleship configuration. Means each instance of this class
 * will create its behavior like width,height and type based on its own configuration.
 *
 * @author munnu
 */

public class BattleShip extends Ship {
    public Ship createShip(String type, int width, int height) {
        this.width = width;
        this.height = height;
        this.type = type;
        return this;
    }

    public int getPower(String type) {
        return BattleShipType.valueOf(type).getPower();
    }
}
