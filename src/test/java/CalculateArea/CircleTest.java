package CalculateArea;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CircleTest {

    protected Circle test;

    @BeforeEach
    public void setUp(){
        test = new Circle(1);
        test.findAreaOf();
    }

    @Test
    public void typeOfCircleIsCircleTest(){
        Circle test = new Circle(1);

        assertTrue(test instanceof Circle);
    }

    @Test
    public void circleStoresRadiusCorrectlyTest(){
        Circle test = new Circle(1);
        assertEquals(1, test.getRadius());
    }

    @Test
    public void areaOfCircleWithRadiusOneTest(){
        Circle test;
        test = new Circle(1);

        assertEquals("3.14", test.findAreaOf(), "A Circle with a radius of 1 will have an area of 3.14.");

    }

    @Test
    public void areaOfCircleWithRadiusZeroTest(){
        Circle test;
        test = new Circle(0);

        assertEquals("0.0", test.findAreaOf(), "A Circle with a radius of 0 will have an area of 0.");
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
    void getRadiusTest() {
        assertEquals(1, test.getRadius());
    }

    @Test
    void getAreaTest() {
        assertEquals(3.14f, test.getArea());
    }
}