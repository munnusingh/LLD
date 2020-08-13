package com.game.battleship;

/**
 * This class allocates battle area of each player in ocean and having ships allocated under the given boundary conditions
 *
 * @author munnu
 */
public class BattleArea {

    private int width;
    private char height;

    private int area[][];
    private Ship[] ship;
    private int nextShipPosition = 0;
    private int totalPower = 0;

    public BattleArea(int width, char height) {
        this.width = width;
        this.height = height;
        this.area = new int[height - 64][width];
    }

    public int getWidth() {
        return width;
    }

    public char getHeight() {
        return height;
    }

    public int[][] getArea() {
        return area;
    }

    public Ship[] addTotalShips( int totalShips) {
        this.ship = new Ship[totalShips];
        return this.ship;
    }

    public void addShipToBattleArea(Ship ship, String location) {
        this.ship[nextShipPosition] = ship;
        nextShipPosition++;
        char yCoord = location.charAt(0);
        int xCoord = Integer.parseInt(location.substring(1));

        for (int i = yCoord - 65; i < yCoord - 65 + ship.getHeight(); i++) {
            for (int j = xCoord - 1; j < xCoord - 1 + ship.getWidth(); j++) {
                area[i][j] = ship.getPower(ship.getType());
                totalPower += area[i][j];
            }
        }
    }

    public int reduceTotalPower() {
        return --totalPower;
    }

    public int getTotalPower() {
        return totalPower;
    }

}
