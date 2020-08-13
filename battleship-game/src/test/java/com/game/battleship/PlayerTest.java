package com.game.battleship;

import org.junit.Assert;
import org.junit.Test;

public class PlayerTest {

    @Test
    public void Should_Hit_IfShoot(){
        Player player1 = new Player("Player1");
        Player player2 = new Player("Player2");
        player1.addMissile("A1");
        populateBattleArea(player2);
        Assert.assertTrue(player1.shoot(player2));
    }

    @Test
    public void Should_Miss_IfShoot(){
        Player player1 = new Player("Player1");
        Player player2 = new Player("Player2");
        player1.addMissile("A2");
        populateBattleArea(player2);
        Assert.assertFalse(player1.shoot(player2));
    }

    @Test
    public void Should_ReturnTrue_IfIsDown(){
        Player player = new Player("Player");
        player.createBattleArea("5 E");
        player.addTotalShipsToBattleArea(1);
        Assert.assertTrue(player.isDown());
    }

    @Test
    public void Should_ReturnFalse_IfNotDown(){
        Player player = new Player("Player");
        player.createBattleArea("5 E");
        player.addTotalShipsToBattleArea(1);
        player.addShipInBattleArea("P", 1, 1, "A1");
        Assert.assertFalse(player.isDown());
    }

    @Test
    public void Should_CreateBattleArea(){
        String battleAreaDimensions = "5 Z";
        Player player = new Player("Player");
        BattleArea battleArea = player.createBattleArea(battleAreaDimensions);
        Assert.assertArrayEquals(new int[]{26, 5}, new int[]{battleArea.getArea().length, battleArea.getArea()[0].length});
    }

    @Test
    public void Should_AddTotalShipsBattleArea(){
        Player player = new Player("Player");
        player.createBattleArea("5 E");
        Ship[] ship = player.addTotalShipsToBattleArea(5);
        Assert.assertEquals(5, ship.length);
    }

    @Test
    public void Should_AddShipsToBattleArea(){
        String battleAreaDimensions = "6 F";
        Player player = new Player("Player");
        BattleArea battleArea = player.createBattleArea(battleAreaDimensions);
        player.addTotalShipsToBattleArea(5);
        player.addShipInBattleArea("Q", 2 , 2, "A4");
        int playerAArea[][] = battleArea.getArea();
        Assert.assertArrayEquals(new int[]{2,2,2,2}, new int[]{playerAArea[0][3], playerAArea[0][4], playerAArea[1][3], playerAArea[1][4]});
    }

    private BattleArea populateBattleArea(Player player){
        BattleArea battleArea = player.createBattleArea("2 B");
        battleArea.addTotalShips( 1);
        Ship ship = new BattleShip();
        ship.createShip("P", 1, 1);
        battleArea.addShipToBattleArea(ship, "A1");
        return battleArea;
    }
}
