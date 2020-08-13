package com.game.battleship;

import org.junit.Assert;
import org.junit.Test;

public class BattleAreaTest {
    @Test
    public void Should_SetShipLocationAndPower_When_AddShip(){
        BattleArea battleArea = new BattleArea(5, 'E');
        battleArea.addTotalShips( 1);
        Ship ship = new BattleShip();
        ship = ship.createShip("Q", 1, 1);
        battleArea.addShipToBattleArea(ship, "B2");

        for (int i = 0; i < battleArea.getArea().length; i++) {
            for (int j = 0; j < battleArea.getArea()[i].length; j++) {
                if(i==1 && j == 1)
                {
                    Assert.assertEquals(2, battleArea.getArea()[i][j]);
                }
                else
                {
                    Assert.assertEquals(0, battleArea.getArea()[i][j]);
                }
            }
        }
    }

}
