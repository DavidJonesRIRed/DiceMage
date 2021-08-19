package com.DavidJones;

import Dice.Cup;
import GameLoop.GameLoop;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Cup myCup = new Cup();
        int multiplier = 0;

/*        myCup.roll();
        System.out.println(myCup.displayCup());
        multiplier = myCup.MaxRepeatingElementInPlace();*/

        GameLoop myGame = new GameLoop();

        myGame.createPlayers(2);
        myGame.displayPlayers();
        myGame.gameLoop();


    }
}
