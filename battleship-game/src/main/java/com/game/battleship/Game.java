package com.game.battleship;

import java.util.List;

public class Game {

    Player player1, player2;

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Missing fileName");
            System.exit(1);
        }

        List<String> input = FileUtils.readFile(args[0]);
        for (String string : input) {
            System.out.println(string);
        }

        Game game = new Game();
        game.startGame(input);

    }

    public void startGame(List<String> input) {
        player1 = new Player("Player-1");
        player2 = new Player("Player-2");

        player1.createBattleArea(input.get(0));
        player2.createBattleArea(input.get(0));

        addShipsToBattleArea(input);

        player1.addMissile(input.get(input.size() - 2));
        player2.addMissile(input.get(input.size() - 1));

        play();
    }

    /**
     * Read totalships and ship coordinates as input and place ships on each Player's battleArea
     * at the respective coordinates
     *
     * @param input
     * @return
     */
    public void addShipsToBattleArea(List<String> input) {
        // Add totalShips to each battleArea
        int totalShips = new Integer(input.get(1));
        player1.addTotalShipsToBattleArea(totalShips);
        player2.addTotalShipsToBattleArea(totalShips);

        // Add different type of ships to each battleArea
        for (int i = 0; i < totalShips; i++) {
            String[] battleShipDetail = input.get(i + 2).split(" ");
            player1.addShipInBattleArea(battleShipDetail[0], new Integer(battleShipDetail[1]), new Integer(battleShipDetail[2]), battleShipDetail[3]);
            player2.addShipInBattleArea(battleShipDetail[0], new Integer(battleShipDetail[1]), new Integer(battleShipDetail[2]), battleShipDetail[4]);
        }

    }

    void play() {

        boolean win = false;
        while (!win) {

            if (shootUntil(player1, player2)) {
                break;
            }

            if (shootUntil(player2, player1)) {
                break;
            }

        }
    }

    private boolean shootUntil(Player playerA, Player playerB) {
        boolean win = false;
        if (playerA.getMissiles().size() == 0) {
            System.out.println(playerA.getPlayerName() + " has no more missiles left to launch");
        } else {
            boolean hit = true;
            while (hit && playerA.getMissiles().size() > 0) {
                hit = playerA.shoot(playerB);
                if (playerB.isDown()) {
                    System.out.println(playerA.getPlayerName() + " won the battle");
                    win = true;
                    break;
                }
            }
        }
        return win;
    }
}
