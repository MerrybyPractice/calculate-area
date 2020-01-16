package CalculateArea;

import java.text.ParseException;

public class Square implements Shape{

    private float side;
    private float area;

    public Square(float side){this.side = side;};

    @Override
    public String findAreaOf() {
        System.out.println("Line 15 findAreaOf " + this.side);
        try {
            Double area = Math.pow(this.side, 2);
            System.out.println("Line 18 findAreaOf " + area);
            Number numberRoundedArea = this.formattedRoundArea(area);
            System.out.println("Line 20 findAreaOf " + numberRoundedArea);
            System.out.println("Line 21 findAreaOf, floatValue of area " + numberRoundedArea.floatValue());
            return numberRoundedArea.toString();

        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Number formattedRoundArea(Double area) throws ParseException {

        System.out.println("In formattedRoundArea " + Math.round(area*100)/100.f);
        return Math.round(area*100)/100.f;
    }

    public float getSide() {
        return side;
    }
}
