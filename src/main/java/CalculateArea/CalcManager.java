package CalculateArea;

import java.util.HashMap;


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

    private Square square;
    private Circle circle;
    private Triangle triangle;
    private CalcRunnable squareRunnable;
    private CalcRunnable circleRunnable;
    private CalcRunnable triangleRunnable;

    /**
     * public HashMap<String, Float> calculateArea(int input)
     *
     * @param input: int input passed in to calculateArea is then utilized to create every Shape(Square, Circle,
     *             Triangle) instance associated with that instance of CalcManager.
     * @return a HashMap<String, Float> containing String shape Keys associated with their calculated Float area Values.
     *
     * Calls the private method CalcManager.setUp.
     */
    public HashMap<String, Float> calculateArea(int input){

        this.setUp(input);

        Thread squareThread = new Thread(squareRunnable);
        Thread circleThread = new Thread(circleRunnable);
        Thread triangleThread = new Thread(triangleRunnable);

        squareThread.start();
        circleThread.start();
        triangleThread.start();

        HashMap<String, Float> areaHashMap = new HashMap<String, Float>();

        try {
            squareThread.join();
            areaHashMap.put("square", square.getArea());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            circleThread.join();
            areaHashMap.put("circle", circle.getArea());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            triangleThread.join();
            areaHashMap.put("triangle", triangle.getArea());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return areaHashMap;
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
    private void setUp(int input){

        square = new Square(input);
        squareRunnable = new CalcRunnable(square, "Square Thread");

        circle = new Circle(input);
        circleRunnable = new CalcRunnable(circle, "Circle Thread");

        triangle = new Triangle(input);
        triangleRunnable = new CalcRunnable(triangle, "Triangle Thread");
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
        prettyBuilder.append("Given Input of " + square.getSide() + " units: \n");
        prettyBuilder.append("\n");
        areaHashMap.forEach((k,v) -> prettyBuilder.append("A " + k + " has an area of " + v + ".\n"));
        return prettyBuilder.toString();
    }

}
