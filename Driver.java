/*
 * @Author Shinya Aoi
 * CSS 143A
 * FractionV2
 *
 * update 04/11/2018
 */

/**
 * This class is the driver of the fraction, fractionCounter,
 * and objectList classes. Read a file and make an object array
 * with its reduced form if its possible. Then, compare to the
 * existing fractions in the array of object.
 */

import java.io.*;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) throws FileNotFoundException {

        ObjectList objectList = new ObjectList();
        FractionV2 fraction;
        Scanner inputFile = new Scanner(new FileInputStream("fractions.txt"));

        //Reading each fraction from the text file.
        while (inputFile.hasNext()) {
            int numerator, denominator;
            String readFraction = inputFile.next();
            String[] separateFraction = readFraction.split("/");
            numerator = Integer.parseInt(separateFraction[0]);
            denominator = Integer.parseInt(separateFraction[1]);

            boolean check = false;
            fraction = new FractionV2(numerator, denominator);

            int stop = objectList.getNumElements();
            for (int j = 0; j < stop; j++) { //iterates in each objectList
                FractionCounter exist = (FractionCounter) objectList.get(j);//To call in later as a counter class
                if (exist.compareAndIncrement(fraction)) {
                    check = true;
                    break;
                }
            }

            if (!check) {
                FractionCounter newFraction = new FractionCounter(fraction);
                objectList.add(newFraction);
            }

        }

        // This code prints out all the unique fraction with their reduced form.
        int stop = objectList.getNumElements();
        for (int h = 0; h < stop; h++) {
            System.out.println(objectList.get(h));
        }
        inputFile.close();
    }
}
