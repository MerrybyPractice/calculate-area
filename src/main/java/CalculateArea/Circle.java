package CalculateArea;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;

import static java.math.BigDecimal.valueOf;

public class Circle implements Shape {

    private float radius;
    private float area;

    public Circle(float radius){
        this.radius = radius;
    }

    @Override
    public String findAreaOf() {

        try {
            Double area = (Math.PI * Math.pow(this.radius, 2));
            Float roundedArea = this.formattedRoundArea(area);
            this.area = roundedArea;
            return roundedArea.toString();

        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public Float formattedRoundArea(Double area) throws ParseException {

        BigDecimal areaBigDecimal = new BigDecimal(area);

        BigDecimal roundedAreaBigDecimal = areaBigDecimal.setScale(2, RoundingMode.HALF_EVEN);
        return roundedAreaBigDecimal.floatValue();
    }

//    Getters and Setters:

    public float getRadius() {
        return radius;
    }

    public float getArea() {
        return area;
    }
}
