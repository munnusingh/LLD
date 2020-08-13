package com.game.battleship;

/**
 * Missile class will represent target location by cellRow and cellColummn
 *
 * @author munnu
 */
public class Missile {

    private int cellRow;
    private int cellCol;
    private String targetLocation;

    public Missile(String targetLocation) {
        this.cellRow = targetLocation.charAt(0) - 65;
        this.cellCol = new Integer(targetLocation.substring(1)) - 1;
        this.targetLocation = targetLocation;
    }

    public int getCellRow() {
        return cellRow;
    }

    public int getCellCol() {
        return cellCol;
    }

    public String getTargetLocation() {
        return targetLocation;
    }
}
