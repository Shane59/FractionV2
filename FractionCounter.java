/*
 * @Author Shinya Aoi
 * CSS 143A
 * FractionV2
 *
 * update 04/11/2018
 */

/**
 * This class is to compare the current fraction to the existing fraction.
 * If the current fraction is existed already, its count increments by one.
 * If not, the fraction will be added to the objectList with count 1.
 */

public class FractionCounter {
    private Fraction theFraction; //new fraction object.
    private int counter = 1;

    //default constructor
    public FractionCounter(){
        theFraction = new Fraction();
    }
    //Overloading constructor to apply the current fraction.
    public FractionCounter(Fraction fraction){
        this.theFraction = fraction;
    }
    /*
     * This method to see if the same fraction as current fraction appeared
     * before in the text file, and if so, increase by one, and return true.
     */
    public boolean compareAndIncrement(Fraction newFraction){
        if(theFraction.equals(newFraction)) {
            counter++;
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        return theFraction+" has a counter of "+counter;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
