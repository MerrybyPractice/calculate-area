package CalculateArea;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * public class Square implements Shape
 *
 *
 * The Square class manages the calculations and rounding for Squaress.
 * Available through the Square Class:
 *      findAreaOf - Square specific implementation
 *      formattedRoundArea - Standard for package
 *      getSide - returns the private float side
 *      getArea - returns the private float area
 */
public class Square implements Shape{

    private float side;
    private float area;
    private String type = "Square";

    /**
     * Square Class Constructor
     * @param side: Float passed in and taken as the value of one of the sides of the Square
     * Returns a Square instance with this.side set to side.
     */
    public Square(float side){this.side = side;};

    /**
     * Square.findAreaOf()
     * @return String area rounded to two decimal points.
     * accesses the private side property and sets the private area property
     */
    @Override
    public String findAreaOf() {

            Double area = Math.pow(this.side, 2);
            Float numberRoundedArea = this.formattedRoundArea(area);
            this.area = numberRoundedArea;
            return numberRoundedArea.toString();

    }

    /**
     * Square.formattedRoundArea(Double area)
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
     * Triangle.getSide()
     * @return: float side
     * side set in the Triangle class constructor
     */
    public float getSide() {
        return side;
    }

    /**
     * Square.getArea()
     * @return: float area
     * area set in the findAreaOf method
     */
    @Override
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
