package CalculateArea;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SquareTest {

    @Test
    public void typeOfSquareIsSquare(){
        Square test = new Square(1);

        assertTrue(test instanceof Square);
    }

    @Test
    public void squareStoresSideCorrectly(){
        Square test = new Square(1);
        assertEquals(1, test.getSide());
    }

    @Test
    public void areaOfSquareWithSidesOneTest(){
        Square test = new Square(1);

        assertEquals("1.0", test.findAreaOf(), "A Square with sides of 1 will have an area of 1.");

    }

    @Test
    public void areaOfSquareWithSidesZeroTest(){
        Square test = new Square(0);

        assertEquals("0.0", test.findAreaOf(), "A Square with sides of 0 will have an area of 0.");
    }

    @Test
    public void areaOfSquareWithSidesTwoPointThree(){
        Square test = new Square(2.3f);
        assertEquals("5.29", test.findAreaOf());
    }

}