package CalculateArea;

import javafx.concurrent.Task;

/**
 * public class CalcRunnable implements Runnable
 *
 * Overrides the run() method from Runnable.
 *
 * Convenience class for creating and manipulating a Runnable. Run Method contains the logic necessary to find the area
 * of each shape dynamically on its own thread.
 */
public class CalcRunnable implements Runnable {

    private Shape shape;
    private String threadName;

    /**
     * public CalcRunnable(Shape shape, String threadName)
     *
     * @param shape: the Shape Object that the area will be calculated for in the thread constructed by this runnable
     * @param threadName: String threadName stored for identification proposes, and to plan for future use of various
     *                  Thread methods that take thread names as parameters.
     */
    public CalcRunnable(Shape shape, String threadName){
        this.shape = shape;
        this.threadName = threadName;
    }

    /**
     * public void run()
     *
     * Overrides the Runnable.run() method.
     * Provides the runnable with the logic necessary to access the thread specific shape and call Shape.findAreaOf().
     */
    @Override
    public void run() {

        try {
            this.shape.findAreaOf();
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
// Getters and Setters

    /**
     * public Shape getShape
     * @return Shape shape
     *
     * Exposes private Shape shape
     * shape is set when CalcRunnable instance is instantiated
     */
    public Shape getShape() {
        return shape;
    }

    /**
     * public String threadName
     * @return String threadName
     *
     * Exposes private String threadName
     * threadName is set when CalcRunnable instance is instantiated
     */
    public String getThreadName() {
        return threadName;
    }
}
