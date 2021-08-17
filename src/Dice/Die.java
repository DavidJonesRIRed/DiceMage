package Dice;

public class Die {
    public int numberOfSides;
    public int faceUpValue;

    public Die(){
        numberOfSides = 6;
        this.roll();
    }

    public Die(int numberOfSides){
        this.numberOfSides = numberOfSides;
    }

    public int getFaceUpValue(){
        return faceUpValue;
    }

    public int roll(){
        faceUpValue = (int) (Math.random() * (numberOfSides))+1;
        return faceUpValue;
    }

    public int roll(int lowNumber){
        faceUpValue = (int) (Math.random() * (numberOfSides))+lowNumber;
        return faceUpValue;
    }

}
