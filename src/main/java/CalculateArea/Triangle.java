package CalculateArea;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * public class Triangle implements Shape
 *
 *
 * The Triangle class manages the calculations and rounding for Triangles.
 * Available through the Triangle Class:
 *      findAreaOf - Triangle specific implementation
 *      formattedRoundArea - Standard for package
 *      getSide - returns the private float side
 *      getArea - returns the private float area
 */
public class Triangle implements Shape {

    private float side;
    private float area;
    private String type = "Triangle";

    /**
     * Triangle Class Constructor
     * @param side: Float passed in and taken as the value of one of the sides of the Triangle
     * Returns a Triangle instance with this.side set to side.
     */
    public Triangle(float side){
        this.side = side;
    }

    /**
     * Triangle.findAreaOf()
     * @return String area rounded to two decimal points.
     * accesses the private side property and sets the private area property
     */
    @Override
    public String findAreaOf() {
        Double area = heronsFormula(this.side);

        Float formattedRoundArea = formattedRoundArea(area);
        this.area = formattedRoundArea;
        return formattedRoundArea.toString();
    }

    /**
     * Triangle.formattedRoundArea(Double area)
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

    /**
     * Triangle.heronsFormula(float side)
     *
     * @param side: Float utilized as the side of a triangle for the purpose of finding its area.
     * @return Double area as determined by Herons formula.
     *
     * Heron's formula for finding the area of a triangle utilizing only knowledge of the length of its sides. Given
     * that the triangles being dealt with in CalculateArea are equilateral, side is passed in once and used for all
     * three sides.
     *
     * Written explicitly for readability.
     */
    protected Double heronsFormula(float side){

        float semi = (this.side *3)/2;
        float paren = semi - side;
        double reduceParen = Math.pow(paren, 3);
        double parenBySemi = semi * reduceParen;

        return Math.sqrt(parenBySemi);
    }

    /**
     * Triangle.getSide()
     * @return: float side
     * side set in the Triangle class constructor
     */
    public float getSide() {
        return side;
    }

    /**
     * Triangle.getArea()
     * @return: float area
     * area set in the findAreaOf method
     */
    public Float getArea() {
        return area;
    }

    /**
     * Triangle.getType()
     * @return String type
     * type stored in each instance of Triangle as 'triangle'
     */
    @Override
    public String getType() {
        return type;
    }

}

