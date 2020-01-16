package CalculateArea;

import java.text.ParseException;

public class Square implements Shape{

    private float side;
    private float area;

    public Square(float side){this.side = side;};

    @Override
    public String findAreaOf() {
        try {
            Double area = Math.pow(this.side, 2);
            Float numberRoundedArea = this.formattedRoundArea(area);
            this.area = numberRoundedArea;
            return numberRoundedArea.toString();

        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Float formattedRoundArea(Double area) throws ParseException {

        return Math.round(area*100)/100.f;
    }

    public float getSide() {
        return side;
    }

    public float getArea() {
        return area;
    }
}
