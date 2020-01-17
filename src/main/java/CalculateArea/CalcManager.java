package CalculateArea;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * public class CalcManager
 *
 * The CalcManager class brings the Shapes and CalcRunnable classes together to create shape specific Threads, start them,
 * wait until they have died, and then accesses the updated properties on specific Shape instances to retrieve the areas
 * calculated. It also provides access to a convenience method for pretty printing completed sets of calculated Areas by.
 *
 * Available through the CalcManager Class:
 *    calculateArea - instantiates threads, starts threads, waits for .join on each thread, and accesses each Shape
 *                  instance to generate and return a HashMap of String Shape Keys and Float area Values.
 *    prettyPrint - iterates over the hashMap returned by calculateArea and returns a prettified stringy version via
 *                  use of a StringBuilder.
 */
public class CalcManager{

    private int input;
    private HashMap<Shape, Runnable> runnableHashMap = new HashMap<Shape, Runnable>();
    private List<Thread> threadList = new ArrayList<Thread>();

    /**
     * public HashMap<String, Float> calculateArea(int input)
     *
     * @param inputFromUser: double input provided by the end user and passed in to calculateArea is then utilized to
     *                     create every Shape(Square, Circle, Triangle) instance associated with that instance of CalcManager.
     *
     * @return a HashMap<String, Float> containing String shape Keys associated with their calculated Float area Values.
     *
     * Calls the private method CalcManager.setUp.
     */
    public HashMap<String, Float> calculateArea(Double inputFromUser) throws CannotComputeAreaWithNegativeException {

        if (inputFromUser < 0){
            throw new CannotComputeAreaWithNegativeException("Inputs must be above 0. Please try again with a positive number.");
        } else {

            int input = inputFromUser.intValue();

            this.input = input;

            this.setUp(input);

            startThreads();
            HashMap<String, Float> areaHashMap = joinThreads();
            return areaHashMap;
        }
    }

    /**
     * private void setUp:
     * Convenience method off of the CalcManager class that instantiates each of the three Shape objects,
     * and then generates a Runnable utilizing the CalcRunnable class.
     *
     * Strictly designed to be called at the top of CalcManager.calculateArea.
     *
     * If additional shapes are added, they will need to be placed here in addition to their respective files.
     *
     * @param input int, passed down from calculateArea. Passed into each Shape instantiation.
     */
    protected void setUp(int input){

        Square square = new Square(input);
        CalcRunnable squareRunnable = new CalcRunnable(square, "Square Thread");
        runnableHashMap.put(square, squareRunnable);

        Circle circle = new Circle(input);
        CalcRunnable circleRunnable = new CalcRunnable(circle, "Circle Thread");
        runnableHashMap.put(circle, circleRunnable);

        Triangle triangle = new Triangle(input);
        CalcRunnable triangleRunnable = new CalcRunnable(triangle, "Triangle Thread");
        runnableHashMap.put(triangle, triangleRunnable);
    }

    /**
     * private void startThreads()
     *
     * Gathers all activities related to starting threads into one function call.
     * Accesses the runnableHashMap created in setUp and instantiates a number of threads for each <Shape, Runnable> pair.
     */
    private void startThreads(){

        for (Shape key : runnableHashMap.keySet()){

            Runnable threadRunnable = runnableHashMap.get(key);

            threadList.add(new Thread(threadRunnable, key.toString()));
        }

        for(Thread thread : threadList){

            thread.start();
        }
    }

    /**
     * private HashMap <String, Float> joinThreads()
     * @return areaHashMap
     * Throws InterruptionException.
     *
     * Waits for each thread to die via a .join() method and then accesses each Shape instance and adds its String Type
     * and Float Area to the areaHashMap.
     */
    private HashMap<String, Float> joinThreads() {
        HashMap<String, Float> areaHashMap = new HashMap<String, Float>();
        for (Thread thread : threadList) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("Your " + thread.getName() + " thread has been interrupted");
                e.printStackTrace();
            }
        }

        for (Shape shape : runnableHashMap.keySet()) {
            areaHashMap.put(shape.getType(), shape.getArea());
        }
        return areaHashMap;
    }

    /**
     * public String prettyPrint(HashMap<String, Float> areaHashMap)
     *
     * @param areaHashMap: HashMap<String, Float>
     * @return String version of the StringBuilder constructed during the method.
     *
     * Iterates over the passed in HashMap and appends a version of each Key Value Pair formatted as an English sentence.
     * First line declares what input was given, while each subsequent line refers directly to one of the Areas
     * calculated and stored in a Shape Object.
     */
    public String prettyPrint(HashMap<String, Float> areaHashMap){
        StringBuilder prettyBuilder = new StringBuilder(300);
        prettyBuilder.append("\n Given Input of ").append(input).append(" units: \n");
        prettyBuilder.append("\n");
        areaHashMap.forEach((k,v) -> prettyBuilder.append("A ").append(k).append(" has an area of ").append(v).append(".\n"));
        return prettyBuilder.toString();
    }

    //Getters and Setters

    /**
     * public int getInput()
     * @return String input
     *
     * Exposes private String input
     * Input is set inside of calculateArea
     */
    public int getInput() {
        return input;
    }

    /**
     * public HashMap<Shape, Runnable> getRunnableHashMap()
     * @return HashMap<Shape, Runnable> runnableHashMap
     *
     * Exposes private HashMap runnableHashMap
     * runnableHashMap is set in joinThreads
     */
    public HashMap<Shape, Runnable> getRunnableHashMap() {
        return runnableHashMap;
    }

    /**
     * public List<Thread> getThreadList
     * @return List<Thread> threadList
     *
     * Exposes private List threadList
     * threadList is set in startThreads
     */
    public List<Thread> getThreadList() {
        return threadList;
    }

    /**
     * public class CannotComputeAreaWithNegativeException extends Exception
     *
     * Exception class creating a custom exception for use when a negative number is passed in.
     */
    public class CannotComputeAreaWithNegativeException extends Exception {
        /**
         * @param errorMessage: String errorMessage is passed in at instantiation so each instance provides a unique
         *                    and useful message given its location.
         *
         */
        public CannotComputeAreaWithNegativeException(String errorMessage) {
            super(errorMessage);
        }
    }
}
