package Player;

import Dice.Cup;
import Monster.Monster;

import java.util.ArrayList;
import java.util.List;

public class Player {
    public int health;
    public int power;
    public String name;
    public Cup playerCup;
    public int mana;
    public List<Monster> playerMonsters = new ArrayList<Monster>();

    public Player(String name){
        health = 20;
        power = 5;
        this.name = name;
        playerCup = new Cup(power);
        mana = 5;
    }

    public void addMonster(int monster){
        Monster newMonster = new Monster(monster);
        playerMonsters.add(newMonster);
    }

    public void displayStatus(){
        System.out.println("Player Name " + name);
        System.out.println("Player health " + health);
        System.out.println("Player power " + power);
        System.out.println("Player mana " + mana);
        System.out.println("Player amount of monsters " + playerMonsters.size());
        System.out.println();
    }
}
