package CalculateArea;

import java.util.HashMap;

public class Main {
    public static void main(String[] args){

        CalcManager calcAreaValues = new CalcManager();
        HashMap <String, Float> areaHashMap = null;
        try {
            areaHashMap = calcAreaValues.calculateArea(18.2);
        } catch (CalcManager.CannotComputeAreaWithNegativeException e) {
            e.printStackTrace();
        }
        System.out.println(calcAreaValues.prettyPrint(areaHashMap));

    }
}
