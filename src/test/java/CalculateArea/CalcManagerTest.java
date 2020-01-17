package CalculateArea;


import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Array;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class CalcManagerTest {

    protected CalcManager test;
    protected HashMap<Shape, Runnable> testSetUpHashMap;
    protected Collection<Runnable> testSetUpHashMapValuesCollection;
    protected Object[] testStringValuesArray;

    @BeforeEach
    public void setUp(){
        test = new CalcManager();
        test.setUp(3);
        testSetUpHashMap = test.getRunnableHashMap();
        testSetUpHashMapValuesCollection = testSetUpHashMap.values();
        testStringValuesArray = testSetUpHashMapValuesCollection.toArray();
    }

    @Test
    public void calcManagerIsInstanceOfCalcManagerTest(){

        assertTrue(test instanceof CalcManager);
    }

    @Test
    public void calcManagerOnlyAcceptsPositiveTest(){
        try {
            CalcManager invalidInputTest = new CalcManager();
            invalidInputTest.calculateArea(-1.00);
            } catch (CalcManager.CannotComputeAreaWithNegativeException e){
            assertEquals("Inputs must be above 0. Please try again with a positive number.", e.getMessage());
        }

    }

    @Test
    public void calculateAreaTest(){
        HashMap<String, Float> testHashMap = null;
        try {
            testHashMap = test.calculateArea(3.0);
        } catch (CalcManager.CannotComputeAreaWithNegativeException e) {
            e.printStackTrace();
        }
        assertEquals(3.9f, testHashMap.get("Triangle"));
    }

    @Test
    public void setUpAccurateRunnableHashMapTest(){
       assertEquals(3, testSetUpHashMap.size());
    }

    @Test
    public void setUpValuesThreadNameIsRunnableTest(){

        assertTrue(testStringValuesArray[0] instanceof Runnable);
        assertTrue(testStringValuesArray[1] instanceof Runnable);
        assertTrue(testStringValuesArray[2] instanceof Runnable);
    }

}