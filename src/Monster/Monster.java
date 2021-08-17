package Monster;

import Dice.Die;



public class Monster {
    public int defense;
    public int attack;
    public Die monsterDie;
    // enum for rarity?
    //public enum Rarity{ COMMON, UNCOMMON, RARE;}


    public Monster(){
        defense = 1;
        attack = 2;
    }

    public Monster (int rarity){

        switch (rarity){
            case 1:
                //System.out.println("Im common");
                monsterDie = new Die();
                defense = 1;
                attack = monsterDie.roll(2);
                break;
            case 2:
                //System.out.println("Im uncommon");
                monsterDie = new Die(10);
                defense = 2;
                attack = monsterDie.roll(3);
                break;
            case 3:
                //System.out.println("Im rare");
                monsterDie = new Die(16);
                defense = 3;
                attack = monsterDie.roll(4);
                break;
            default:
        }

    }

}
