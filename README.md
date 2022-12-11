Author: Julian Yan  
Date: 1/26/2019  
Title: Shapes with Recursion  
Summary: This program utilizes JavaFX to display shapes that are implemented through recursion. 

Contents: 
* Circle8b.java 
  * This file includes methods to create a Circle8B object, to get the center and radius of a Circle8b object, to set the center and radius of a Circle8B object, to override the abstract draw method and to draw a bullseye.
   * Point getCenter()
   * int getRadius() 
   * void setCenter(Point center)
   * setRadius(int radius)
   * Circle8B(Point center, int radius)
   * Circle8B(Point center, int radius, String name)
   * Circle8B(Circle8B c)
   * Circle8B(Circle8B c, String name)
   * Circle8B()
   * String toString()
   * void draw(Group group, Color c, boolean fill)
   * void drawBullsEye(Group group, boolean fill, int n)
* CreativeShape.java
  * This file creates a class that includes methods that allows the creation of CreativeShape objects and override the abstract draw method and a method that utilizes recursion to draw honeycombs.
    * int getSide()
    * Point getUpperLeft()
    * void setSide(int side)
    * void setUpperLeft(Point upperLeft)
    * CreativeShape(Point upperLeft, int side)
    * CreativeShape(Point upperLeft, int side, String name)
    * CreativeShape(CreativeShape hexagon)
    * CreativeShape()
    * String toString()
    * void draw(Group group, Color c, boolean fill)
    * void drawHoneyComb(Group group, boolean fill, int n)
* Exercise.java
  * The file creates a class that includes 3 methods that all utilize recursion. There is a method to add up all the numbers in an Integer list, find the average of numbers in an Integer list and convert a String into a Character list.
    * Integer sumList(ArrayList<Integer> list)
    * Double findAverage(ArrayList<Integer> list)
    * ArrayList<Character> strToList(String word)
* Fibonacci.java
  * This file creates a class that includes a method that will draw an arc based on the Fibonacci sequence given inputs such as the center point, the previou radius, the current radius, the angle at start and the number of arcs.
    * void draw(Group group, int centerX, int centerY, int prevRadius, int currRadius, int startAngle, int n)
* Point.java
  * This file creates a class that describes a point on the scene.
    * Point()
    * Point(Point point)
    * int getX()
    * int getY()
    * void setX(int x)
    * void setY(int y)
    * String toString()
* Shape.java
  * This file creates a class that includes methods that allows a creation of a Shape object and also an abstract method to draw the Shape.
    * Shape(String name)
    * Shape() 
    * String getShapeName() 
    * void setShapeName(String name)
    * void draw(Group group, Color c, boolean fill)
    * String toString()
    * Color getRandomColor()
* Square.java
  * This file creates a class that includes methods that allows the creation of Square objects and override the abstract draw method and a method that utilizes recursion to draw grid.
    * int getSide()
    * Point getUpperLeft()
    * void setSide(int side)
    * void setUpperLeft(Point upperLeft)
    * Square(Point upperLeft, int side)
    * Square(Point upperLeft, int side, String name)
    * Square(Square square)
    * Square() 
    * String toString()
    * void draw(Group group, Color c, boolean fill)
    * void drawGrid(Group group, boolean fill, int n)
* Triangle.java
  * This file creates a class that includes methods that allows the creation of Triangle objects, an override of the abstract draw method and a method that utilizes recursion to draw a triforce.
    * Point getP1()
    * Point getP2()
    * Point getP3()
    * void setP1(Point p1)
    * void setP2(Point p2)
    * void setP3(Point p3)
    * Triangle(Point p1, Point p2, Point p3)
    * Triangle(Point p1, Point p2, Point p3, String name)
    * Triangle(Triangle tri)
    * Triangle()
    * String toString()
    * void draw(Group group, Color c, boolean fill)
    * void drawTriforce(Group group, boolean fill, int n)