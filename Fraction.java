/*
 * @Author Shinya Aoi
 * CSS 143A
 * FractionV2
 *
 * update 04/11/2018
 */

/**
 * This class is to represent a fraction, and reduce the fraction
 * if it can be divided by their GCD.
 */
public class Fraction {
    private int numerator; //top
    private int denominator; //bottom

    public Fraction(){ //Default constructor with no arguments

    }
    //Overloading with two int values, and reduce the fraction if it is possible.
    public Fraction(int numerator, int denominator){
        int d = findGCD(numerator,denominator);
        if(d==0){
            this.numerator = numerator;
            this.denominator = denominator;
        }
        else {
            this.numerator = numerator / d;
            this.denominator = denominator / d;
        }
    }
    @Override
    public String toString(){
        return numerator+"/"+denominator;
    }

    public boolean equals(Fraction that){
        return this.numerator==that.numerator&&this.denominator==that.denominator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }
    //This method to find the current fraction's GCD.
    public int findGCD(int n, int d){
        if(n==0 || d==0) d=0;
        else {
            int r = n % d;
            while (r != 0) {
                n = d;
                d = r;
                r = n % d;
            }
        }
        return d;
    }
}
