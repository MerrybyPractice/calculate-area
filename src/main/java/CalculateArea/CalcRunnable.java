package CalculateArea;

/**
 * public class CalcRunnable implements Runnable
 *
 *
 * Convenience class for 
 */
public class CalcRunnable implements Runnable {

    private Shape shape;
    private String threadName;

    public CalcRunnable(Shape shape, String threadName){
        this.shape = shape;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        try {
            this.shape.findAreaOf();

        } catch (Exception e){

        }
    }
}
