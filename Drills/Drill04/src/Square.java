/*
 * Here is your example class.
 * You will need to create two classes that are very similar to this one: Triangle and Circle.
 * To create these classes:
 * 
 * Right click on the same package that this class is in,
 * 	choose New -> Class. 
 * Extend the Shape class.
 * Create a constructor with the necessary corresponding instance variables. You
 * 	can see how the constructors are called in Drill04TestClass.java.
 * Override the area() method.
 * I also included a toString method here out of habit. I would recommend you do
 * 	so as well for practice, but we won't check it. We will learn soon that it is
 * 	also common practice to override the equals() and hashCode() methods as well.
 */
public class Square extends Shape {
	
	/* 
	 * You will need to declare whatever instance variables you need in the Triangle
	 * and Circle classes as well.
	 */
    private double size;

    /*
     * You will need to create the correct constructors in order for the Drill04TestClass.java
     * tests to work.
     */
    public Square(double size) {
        this.size = size;
    }

    /*
     * And lastly you will need to override this method.
     */
    @Override
    public double area() {
        return size * size;
    }

    public String toString() {
        return "Square(area = " + area() + ")";
    }
}
