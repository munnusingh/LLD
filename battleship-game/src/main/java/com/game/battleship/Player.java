package com.game.battleship;

import java.util.ArrayList;
import java.util.List;

/**
 * This Class represent Players . They have List of missiles, BattleArea and serveral actions based on the game rules
 *
 * @author munnu
 */
public class Player {

    List<Missile> missiles = new ArrayList<>();
    private String playerName;
    BattleArea battleArea;

    Player(String name) {
        this.playerName = name;
    }

    /**
     * Read battle area dimensions as input and create battleArea.
     *
     * @param battleAreaDimensions
     * @return
     */
    public BattleArea createBattleArea(String battleAreaDimensions) {

        String[] dimensions = battleAreaDimensions.split(" ");
        battleArea = new BattleArea(new Integer(dimensions[0]), dimensions[1].charAt(0));

        return battleArea;
    }

    // Add totalShips to each battleArea
    public Ship[] addTotalShipsToBattleArea(int totalShips) {
        return battleArea.addTotalShips(totalShips);
    }

    public void addShipInBattleArea(String type, int width, int height, String location) {
        Ship ship = new BattleShip();
        //Create ship configuration
        ship = ship.createShip(type, width, height);

        // Place ship in battle area
        battleArea.addShipToBattleArea(ship, location);
    }

    /**
     * Read missile target location as input for each Player and add those missiles
     *
     * @param input
     * @return
     */
    public void addMissile(String input) {
        for (String target : input.split(" ")) {
            Missile m = new Missile(target);
            missiles.add(m);
        }
    }

    public boolean shoot(Player player) {
        boolean hit = false;
        //Remove First enqued Missile as it is going to fire
        Missile missile = missiles.remove(0);
        int value = player.getBattleArea().getArea()[missile.getCellRow()][missile.getCellCol()];
        if (value == 0) {
            System.out.println(playerName + " fires a missile with target " + missile.getTargetLocation() + " which got miss");
        } else {
            //Reduce power of opponent by 1 unit
            System.out.println(playerName + " fires a missile with target " + missile.getTargetLocation() + " which got hit");
            player.getBattleArea().getArea()[missile.getCellRow()][missile.getCellCol()] = player.getBattleArea().getArea()[missile.getCellRow()][missile.getCellCol()] - 1;
            player.getBattleArea().reduceTotalPower();
            hit = true;
        }
        return hit;
    }

    public boolean isDown() {
        return (battleArea.getTotalPower() == 0) ? true : false;
    }

    public List<Missile> getMissiles() {
        return missiles;
    }

    public String getPlayerName() {
        return playerName;
    }

    public BattleArea getBattleArea() {
        return battleArea;
    }
}
