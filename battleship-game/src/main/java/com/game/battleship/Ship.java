package com.game.battleship;

/**
 * Class to Represent ship of any configurations(Width,Height and Type)
 *
 * @author munnu
 */
public abstract class Ship {
    int width;
    int height;
    String type;

    public abstract Ship createShip(String type, int width, int height);

    public abstract int getPower(String type);

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getType() {
        return type;
    }
}
