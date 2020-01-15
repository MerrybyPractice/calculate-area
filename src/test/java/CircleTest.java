import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

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
        Circle test = new Circle(1);

        assertEquals(3.14, test.areaOf(), "A Circle with a radius of 1 will have an area of 3.14.");

    }

    @Test
    public void areaOfCircleWithRadiusZeroTest(){
        Circle test = new Circle(0);

        assertEquals(0, test.areaOf(), "A Circle with a radius of 0 will have an area of 0.");
    }

    @Test
    public void invalidCircleRadiusStringTest(){
        fail(new Circle('a'));
    }

}