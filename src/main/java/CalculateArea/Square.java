package CalculateArea;

import java.text.DecimalFormat;
import java.text.ParseException;

public class Square implements Shape{

    private float side;
    private float area;

    public Square(float side){this.side = side;};

    @Override
    public float findAreaOf() {

        try {
            Double area = Math.pow(this.side, 2);
            Number numberRoundedArea = this.formattedRoundArea(area);
            return numberRoundedArea.floatValue();

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

    public float getSide() {
        return side;
    }
}
