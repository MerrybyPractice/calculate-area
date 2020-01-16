package CalculateArea;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class TriangleTest {

    protected Triangle test;

    @BeforeEach
    public void setUp(){
        test = new Triangle(1);
        test.findAreaOf();
    }

    @Test
    public void typeOfTriangleIsTriangle(){


        assertTrue(test instanceof Triangle);
    }

    @Test
    public void triangleStoresSideCorrectly(){

        assertEquals(1, test.getSide());
    }

    @Test
    public void areaOfTriangleWithSidesOneTest(){

        assertEquals("0.43", test.findAreaOf(), "A Triangle with sides of 1 will have an area of 0.43.");

    }

    @Test
    public void areaOfTriangleWithSidesZeroTest(){
        Triangle testZero = new Triangle(0);

        assertEquals("0.0", testZero.findAreaOf(), "A Triangle with sides of 0 will have an area of 0.");
    }

    @Test
    void formattedRoundAreaTest() {
        Float roundTest = test.formattedRoundArea(0.010);

        assertEquals(0.01f, roundTest);
    }

    @Test
    void formattedRoundAreaTestGreaterThanOne(){
        Float roundTestGreaterThanOne = test.formattedRoundArea(1.099);

        assertEquals(1.1f, roundTestGreaterThanOne);
    }

    @Test
    void formattedRoundAreaTestGreaterRoundDown(){
        Float roundTestGreaterThanOne = test.formattedRoundArea(1.099);

        assertEquals(1.1f, roundTestGreaterThanOne);
    }

    @Test
    void heronsFormulaTest() {
        assertEquals(0.4330127018922193, test.heronsFormula(1));
    }

    @Test
    void getSideTest() {
        assertEquals(1, test.getSide());
    }

    @Test
    void getAreaTest() {
        assertEquals(0.43f, test.getArea());
    }
}