package CalculateArea;

import java.text.DecimalFormat;
import java.text.ParseException;

public class Triangle implements Shape {

    private float side;
    private float area;

    public Triangle(float side){
        this.side = side;
    }

    @Override
    public String findAreaOf() {
        Double area = heuronsFormula(this.side);
        try {
            Float formattedRoundArea = formattedRoundArea(area);
            this.area = formattedRoundArea;
            return formattedRoundArea.toString();
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Float formattedRoundArea(Double area) throws ParseException {
        DecimalFormat roundingFormat = new DecimalFormat("#####.##");
        String stringyRoundedNumber = roundingFormat.format(area);
        return Float.parseFloat(stringyRoundedNumber);
    }

    public Double heuronsFormula(float side){
        float semi = (this.side *3)/2;
        float parens = semi - side;
        float reduceParens = parens * parens * parens;
        float parensBySemi = semi * reduceParens;
        Double sqrtParensBySemi = Math.sqrt(parensBySemi);
        return sqrtParensBySemi;

    }

    public float getSide() {
        return side;
    }

    public float getArea() {
        return area;
    }

}
