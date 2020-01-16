package CalculateArea;

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
            System.out.println("Started " + threadName);
        } catch (Exception e){

        }
    }
}
