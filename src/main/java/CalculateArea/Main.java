package CalculateArea;

import java.util.HashMap;

public class Main {
    public static void main(String[] args){

        CalcManager calcAreaValues = new CalcManager();
        HashMap <String, Float> areaHashMap = calcAreaValues.calculateArea(2);
        System.out.println(calcAreaValues.prettyPrint(areaHashMap));

    }


}
