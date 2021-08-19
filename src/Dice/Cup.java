package Dice;


import java.util.*;

public class Cup {
    List<Die> dice = new ArrayList<>();

    public Cup(){
        while(dice.size() < 5){
            dice.add(new Die());
        }
    }

    public Cup(int numberOfDice){
        while(dice.size() < numberOfDice + 1){
            dice.add(new Die());
        }
    }

    public void roll(){
        for(Die die: dice){
            die.roll();
        }
    }

    public void roll(int selection){
        dice.get(selection).roll();
    }

    public void roll(List<Integer> selections){
        for(int selection : selections){
            roll(selection);
        }
    }

    public String displayCup(){
        String output = "";
        for(Die die : dice){
            output += die.faceUpValue + " ";
        }
        return output.trim();
    }

    public List<Integer> CupListInteger(){
        List<Integer> faceUpValues = new ArrayList<>();
        for(Die die : dice){
            faceUpValues.add(die.faceUpValue);
        }
        return faceUpValues;
    }

    public List<Integer> parseSelection(String input){
        String[] inputArr = input.split(" ");

        List<Integer> selections = new ArrayList<>();
        for(String number : inputArr){
            selections.add(Integer.parseInt(number) -1);
        }
        return selections;
    }

    public int MaxRepeatingElementInPlace(){
        ArrayList<Integer> currentFaceUpValues = new ArrayList<>(CupListInteger());
        int power = 0;

        Set<Integer> distinct = new HashSet<>(currentFaceUpValues);
        for(Integer dieFace : distinct){
            if(Collections.frequency(currentFaceUpValues,dieFace) >= 3){
                power = power + 1;
                System.out.println("Max repeating Die number: " + dieFace + ", maximum count: " + Collections.frequency(currentFaceUpValues,dieFace));
            }
        }

        if(power == 0){
            System.out.println("No 3 or more matching die");
        }
        return power;
    }

    public int MaxRepeatingElementInPlace(List<Integer> faceUpValues){
        ArrayList<Integer> currentFaceUpValues = new ArrayList<>(faceUpValues);
        int power = 0;

        Set<Integer> distinct = new HashSet<>(currentFaceUpValues);
        for(Integer dieFace : distinct){
            if(Collections.frequency(currentFaceUpValues,dieFace) >= 3){
                power = power + 1;
                System.out.println("Max repeating Die number: " + dieFace + ", maximum count: " + Collections.frequency(currentFaceUpValues,dieFace));
            }
        }

        if(power == 0){
            System.out.println("No 3 or more matching die");
        }
        return power;
    }
}
