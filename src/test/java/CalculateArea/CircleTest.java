package CalculateArea;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CircleTest {

//    @Before
//    public void setUp() throws Exception {
//    }
//
//    @After
//    public void tearDown() throws Exception {
//    }

    @Test
    public void areaOfCircleWithRadiusOneTest(){
        Circle test;
        test = new Circle(1);

        assertEquals(3.14, test.findAreaOf(), "A Circle with a radius of 1 will have an area of 3.14.");

    }

    @Test
    public void areaOfCircleWithRadiusZeroTest(){
        Circle test;
        test = new Circle(0);

        assertEquals(0, test.findAreaOf(), "A Circle with a radius of 0 will have an area of 0.");
    }
//
//    @Test
//    public void invalidCircleRadiusStringTest(){
//        String a = String.valueOf('a');
//        fail(new Circle(a));
//    }

}