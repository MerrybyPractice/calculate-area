package CalculateArea;/* Circles, Squares, and Triangles are all Shapes that share the
behavior of finding their area based on one known measurement */

import java.text.ParseException;

public interface Shape {

   public String findAreaOf();
   public Number formattedRoundArea(Double area) throws ParseException;

}
