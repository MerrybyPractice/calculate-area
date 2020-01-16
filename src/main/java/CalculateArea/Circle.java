package CalculateArea;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * public class Circle implements Shape
 *
 *
 * The Circle class manages the calculations and rounding for Circles.
 * Available through the Circle Class:
 *      findAreaOf - Circle specific implementation
 *      formattedRoundArea - Standard for package
 *      getSide - returns the private float side
 *      getArea - returns the private float area
 */
public class Circle implements Shape {

    private float radius;
    private float area;
    private String type = "Circle";

    /**
     * Circle Class Constructor
     * @param radius: Float passed in and taken as the value of the radius of the Circle
     * Returns a Circle instance with this.radius set to radius.
     */
    public Circle(float radius){
        this.radius = radius;
    }

    /**
     * Circle.findAreaOf()
     * @return String area rounded to two decimal points.
     * accesses the private radius property and sets the private area property
     */
    @Override
    public String findAreaOf() {

            Double area = (Math.PI * Math.pow(this.radius, 2));
            Float roundedArea = this.formattedRoundArea(area);
            this.area = roundedArea;
            return roundedArea.toString();
    }

    /**
     * Circle.formattedRoundArea(Double area)
     *
     * @param area: Double representing the already calculated Area
     * @return Float area rounded to two decimal points
     *
     * Utilizes BigDecimal for precision during rounding.
     */
    @Override
    public Float formattedRoundArea(Double area){
        BigDecimal areaBigDecimal = new BigDecimal(area);

        BigDecimal roundedAreaBigDecimal = areaBigDecimal.setScale(2, RoundingMode.HALF_EVEN);
        return roundedAreaBigDecimal.floatValue();

    }

//    Getters and Setters:

    /**
     * Triangle.getSide()
     * @return: float radius
     * side set in the Triangle class constructor
     */
    public float getRadius() {
        return radius;
    }

    /**
     * Circle.getArea()
     * @return: float area
     * area set in the findAreaOf method
     */
    @Override
    public Float getArea() {
        return area;
    }

    /**
     * Circle.getType()
     * @return String type
     * type stored in each instance of Circle as 'circle'
     */
    @Override
    public String getType() {
        return type;
    }
}
