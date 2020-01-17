package CalculateArea;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalcRunnableTest {

    protected CalcRunnable testCalcRunnable;
    protected Triangle testShape;

    @BeforeEach
    void setUp() {
        testShape = new Triangle(1);
        testCalcRunnable = new CalcRunnable(testShape, "Test Thread Name");
    }

    @Test
    public void calcRunnableIsInstanceOfCalcRunnableTest(){

        assertTrue(testCalcRunnable instanceof CalcRunnable);
    }

    @Test
    public void calcRunnableHasShapeTest(){
        assertEquals(testShape, testCalcRunnable.getShape());
    }

    @Test
    public void calcRunnableHasThreadNameTest(){
        assertEquals("Test Thread Name", testCalcRunnable.getThreadName());
    }

    @Test
    public void runTest(){
        testCalcRunnable.run();
        assertEquals(0.43f, testShape.getArea());
    }


}