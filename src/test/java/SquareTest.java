import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SquareTest {

//    @Before
//    public void setUp() throws Exception {
//    }
//
//    @After
//    public void tearDown() throws Exception {
//    }

    @Test
    public void areaOfSquareWithSidesOneTest(){
        Square test = new Square(1);

        assertEquals(1, test.areaOf(), "A Square with sides of 1 will have an area of 1.");

    }

    @Test
    public void areaOfSquareWithSidesZeroTest(){
        Square test = new Square(0);

        assertEquals(0, test.areaOf(), "A Square with sides of 0 will have an area of 0.");
    }

    @Test
    public void invalidSquareSidesStringTest(){
        fail(new Square('a'));
}