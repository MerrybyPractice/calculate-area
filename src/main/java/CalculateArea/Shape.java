package CalculateArea;

/* Circles, Squares, and Triangles are all Shapes that share the
behavior of finding their area based on one known measurement */

import java.text.ParseException;

/**
 * Shape Interface
 *
 * Provides standard methods implemented by all Shapes.
 *
 */
public interface Shape {

   public String findAreaOf();
   public Float formattedRoundArea(Double area);

}
