package GameLoop;

import Dice.Cup;
import Monster.Monster;
import Player.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class GameLoop {
    //variables
    Scanner scanner = new Scanner(System.in);
    public List<Player> players = new ArrayList<>();
    public List<Player> playersAlive = new ArrayList<>();
    public List<Player> playersDead = new ArrayList<>();

    public GameLoop(){

    }

    public void createPlayers(int numberOfPlayers){
        String name;
        for(int playerNumber = 1; playerNumber<= numberOfPlayers; playerNumber++){
            System.out.println("Please enter player " + playerNumber + " Name");
            name = scanner.nextLine();
            Player player = new Player(name);
            players.add(player);
            //numberOfPlayer = numberOfPlayer + 1;
        }

        playersAlive = new ArrayList<>(players);
    }

    public void displayPlayers(){
        players.forEach(player -> {
            System.out.println("The current players in the game are " + player.name);
            System.out.println();
        });
    }

    public void displayAlivePlayers(){
        playersAlive.forEach(player -> {
            System.out.println("The current players in the game are " + player.name);
            System.out.println();
        });
    }

    public void displayDeadPlayers(){
        playersDead.forEach(player -> {
            System.out.println("The current players in the game are " + player.name);
            System.out.println();
        });
    }

    public void playerRoll(Cup playerCup){
        playerCup.roll();
        playerCup.displayCup();
    }

    public void playersTurn(Player currentActivePlayer, int playerLocationList) {
        currentActivePlayer.displayStatus();

        playerRoll(currentActivePlayer.playerCup);
        currentActivePlayer.mana += 1;
        summonMonsters(currentActivePlayer);
        attack(currentActivePlayer, playerLocationList);
        currentActivePlayer.displayStatus();
    }

    public void summonMonsters(Player currentActivePlayer){
        char createMonster;
        int monsterType = 0;

        System.out.println();
        System.out.println("Would you like to summon a monster? Y or N");
        createMonster = scanner.next().charAt(0);
        createMonster = Character.toUpperCase(createMonster);
        System.out.println(createMonster);

        if(createMonster != 'Y' && createMonster != 'N'){
            System.out.println();
            System.out.println("You did not enter Y or N, monster phase ends");
            currentActivePlayer.mana -= 1;
            System.out.println("You have suffered mana burn, 1 mana lost");
        }else if(createMonster == 'Y'){
            if(currentActivePlayer.playerMonsters.size() > 0)
            {
                System.out.println("You already have a monster!");
            }else{
                System.out.println("What rarity would you like? 1 : common = cost 2, 2 : uncommon = 3, 3 : rare =" +
                        " cost 4");
                monsterType = scanner.nextInt();

                currentActivePlayer.addMonster(monsterType);
            }

        }else{}


        //currentActivePlayer.displayStatus();
    }

    public void attack(Player currentActivePlayer, int placeInList){
        char attackChoice;
        int damage;
        ArrayList<Player> defendingPlayersInAttack;

        System.out.println();
        System.out.println("Would you like to attack? Y or N");
        attackChoice = scanner .next().charAt(0);
        attackChoice = Character.toUpperCase(attackChoice);

        if(attackChoice != 'Y' && attackChoice != 'N'){
            System.out.println();
            System.out.println("You did not enter Y or N, monster phase ends");
            currentActivePlayer.mana -= 1;
            System.out.println("You have suffered mana burn, 1 mana lost");
        }else if(attackChoice == 'Y'){
            defendingPlayersInAttack = new ArrayList<Player>(defendingPlayers(placeInList));

            if(currentActivePlayer.playerMonsters.size() < 1) {
                damage = 1;
                defendingPlayersInAttack.forEach(player -> {
                    player.health -= damage;
                });
            }else if(currentActivePlayer.playerMonsters.size()>0) {
                damage = currentActivePlayer.playerMonsters.get(0).attack + 1;

                defendingPlayersInAttack.forEach(player -> {
                    player.health -= damage;
                });
            }

        }

        checkAlive();
    }

    public ArrayList<Player> defendingPlayers(int attackingPlayer){
        ArrayList<Player> defendingPlayers = new ArrayList<>();

        for(int indexOfPlayer = 0; indexOfPlayer < playersAlive.size(); indexOfPlayer++){
            if(indexOfPlayer != attackingPlayer){
                defendingPlayers.add(playersAlive.get(indexOfPlayer));
            }
        }

        return defendingPlayers;
    }

    public void checkAlive(){
        for(int index = 0;index < playersAlive.size();index++){
            if(playersAlive.get(index).health <= 0){
                playersDead.add(playersAlive.get(index));
                playersAlive.remove(index);
            }
        }
    }

    public void gameLoop(){
        do{
            for(int currentPlayer = 0; currentPlayer < playersAlive.size();currentPlayer++){
                playersTurn(playersAlive.get(currentPlayer), currentPlayer);
            }
        }while (playersAlive.size() > 1);
    }

}
