package CalculateArea;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CircleTest {

    @Test
    public void typeOfCircleIsCircle(){
        Circle test = new Circle(1);

        assertTrue(test instanceof Circle);
    }

    @Test
    public void circleStoresRadiusCorrectly(){
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




}