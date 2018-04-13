/*
 * @Author Shinya Aoi
 * CSS 143A
 * FractionV2
 *
 * update 04/11/2018
 */

/**
 * This class to store the current fraction and its count into an object array.
 * The object, elements, represents the array of fractions. When the size of array gets full,
 * it will increase the size by 100.
 */

public class ObjectList {
    private Object[] elements = new Object[100];
    private int numElements = 0;

    public ObjectList(){

    }

    public void add(Object shape){
        if(numElements==elements.length) increaseArraySize();//Check see the array size is full
        else {
            elements[numElements++] = shape;
        }
    }

    @Override
    public String toString(){
        String retVal = "";
        for(int i=0; i<numElements; i++){
            if(i==0){
                retVal = retVal+elements[i];
                continue;
            }
            retVal = retVal+ ","+ elements[i];
        }
        return retVal;
    }
    //to get a value i of an object list
    public Object get(int i) {
        return elements[i];
    }

    //increase array when it becomes full.
    private void increaseArraySize(){
        Object[] newMyShape = new Object[elements.length+100];
        System.arraycopy(elements, 0,newMyShape, 0,elements.length);
        elements = newMyShape;
    }
    public int getNumElements() {
        return numElements;
    }

    public void setMyShapes(FractionCounter[] myShapes) {
        this.elements = myShapes;
    }

    public void setNumElements(int numElements) {
        this.numElements = numElements;
    }
}
