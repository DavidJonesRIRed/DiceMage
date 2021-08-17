package com.DavidJones;

import GameLoop.GameLoop;

public class Main {

    public static void main(String[] args) {
	// write your code here

        GameLoop myGame = new GameLoop();

        myGame.createPlayers(2);
        myGame.displayPlayers();
        myGame.gameLoop();


    }
}
