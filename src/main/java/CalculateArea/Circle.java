package CalculateArea;

import java.text.DecimalFormat;
import java.text.ParseException;

import static java.math.BigDecimal.valueOf;

public class Circle implements Shape {

    private float radius;
    private float area;

    public Circle(float radius){
        this.radius = radius;
    }

    @Override
    public float findAreaOf() {

        try {
            Double area = (Math.PI * Math.pow(this.radius, 2));
            Number numberRoundedArea = this.formattedRoundArea(area);
            float roundedArea = numberRoundedArea.floatValue();
            System.out.println(roundedArea);
            this.area = roundedArea;
            System.out.println(roundedArea);
            return roundedArea;

        } catch (ParseException e) {
            e.printStackTrace();
            return -1;
        }

    }

    @Override
    public Number formattedRoundArea(Double area) throws ParseException {

        DecimalFormat df = new DecimalFormat("###.##");

        String stringyRoundedArea = df.format(area);
        System.out.println(stringyRoundedArea);
        return df.parse(stringyRoundedArea);

    }

//    Getters and Setters:

    public float getRadius() {
        return radius;
    }
}
