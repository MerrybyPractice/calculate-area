package CalculateArea;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class TriangleTest {

//    @Before
//    public void setUp() throws Exception {
//    }
//
//    @After
//    public void tearDown() throws Exception {
//    }

    @Test
    public void typeOfTriangleIsTriangle(){
        Triangle test = new Triangle(1);

        assertTrue(test instanceof Triangle);
    }

    @Test
    public void triangleStoresSideCorrectly(){
        Triangle test = new Triangle(1);
        assertEquals(1, test.getSide());
    }

    @Test
    public void areaOfTriangleWithSidesOneTest(){
        Triangle test = new Triangle(1);

        assertEquals("0.43", test.findAreaOf(), "A Triangle with sides of 1 will have an area of 0.43.");

    }

    @Test
    public void areaOfTriangleWithSidesZeroTest(){
        Triangle test = new Triangle(0);

        assertEquals("0.0", test.findAreaOf(), "A Triangle with sides of 0 will have an area of 0.");
    }

}