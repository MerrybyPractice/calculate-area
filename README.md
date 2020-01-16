# calculate-area

A Multi-threaded application that takes in a double and returns a HashMap of Key-Value-Pairs representing the area of a 
Circle, Square, and Equilateral Triangle. 

## CalcManager 

Gathers and manages the processes described in other classes. 


    The CalcManager class brings the Shapes and CalcRunnable classes together to create shape specific Threads, start them,
    wait until they have died, and then accesses the updated properties on specific Shape instances to retrieve the areas
    calculated. It also provides access to a convenience method for pretty printing completed sets of calculated Areas by.
 
    Available through the CalcManager Class:
        calculateArea - instantiates threads, starts threads, waits for .join on each thread, and accesses each Shape
                    instance to generate and return a HashMap of String Shape Keys and Float area Values.
        prettyPrint - iterates over the hashMap returned by calculateArea and returns a prettified stringy version via
                    use of a StringBuilder.



## CalcRunnable

Creates a custom Runnable that is used to instantiate the threads in CalcManager. 


    Convenience class for creating and manipulating a Runnable. Run Method contains the logic necessary to find the area
    of each shape dynamically on its own thread.
 

## Shape

Interface that provides standard methods implemented by all Shapes. 

    These include: 
        String findAreaOf()
        Float formattedRoundArea(Double area)
        Float getArea()
        String getType

### Circle 

 The Circle class implements Shape and manages the calculations and rounding for Circles.
 
    Available through the Circle Class:
        findAreaOf - Circle specific implementation
        formattedRoundArea - Standard for package
        getSide - returns the private float side
        getArea - returns the private float area

### Square

 The Square class implements Shape and manages the calculations and rounding for Squaress.
 
    Available through the Square Class:
          findAreaOf - Square specific implementation
          formattedRoundArea - Standard for package
          getSide - returns the private float side
          getArea - returns the private float area

### Triangle

 The Triangle class implements Shape and manages the calculations and rounding for Triangles.
    
     Available through the Triangle Class:
          findAreaOf - Triangle specific implementation. In the triangle class this method makes use of the 
                        protected method heronsFormula. 
          formattedRoundArea - Standard for package
          getSide - returns the private float side
          getArea - returns the private float area
