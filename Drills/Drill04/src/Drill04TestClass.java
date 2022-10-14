/*
 * Do NOT touch this class.
 * But looking through it will certainly help!
 */
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

//This is an annotation for assigning point values to tests

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Drill04TestClass {
	
	private static final double EPSILON = 0.5;

    @Test
    public void testSquare1() {
        Square square = new Square(5.2);
        double area = square.area();

        System.out.println("Square(5.2) area = " + area);
        assertEquals(27.04, area, EPSILON);
    }
    
    @Test
    public void testSquare2() {
        Square square = new Square(1.1);
        double area = square.area();

        System.out.println("Square(1.1) area = " + area);
        assertEquals(1.21, area, EPSILON);
    }
    
    @Test
    public void testSquare3() {
        Square square = new Square(9.0);
        double area = square.area();

        System.out.println("Square(9.0) area = " + area);
        assertEquals(81, area, EPSILON);
    }
    
    @Test
    public void testTriangle1() {
        Triangle triangle = new Triangle(1.2, 3.5);
        double area = triangle.area();

        System.out.println("Triangle(1.2, 3.5) area = " + area);
        assertEquals(2.1, area, EPSILON);
    }
    
    @Test
    public void testTriangle2() {
        Triangle triangle = new Triangle(10, 10);
        double area = triangle.area();

        System.out.println("Triangle(10, 10) area = " + area);
        assertEquals(50, area, EPSILON);
    }
    
    @Test
    public void testTriangle3() {
        Triangle triangle = new Triangle(21.2, 15.2);
        double area = triangle.area();

        System.out.println("Triangle(21.2, 15.2) area = " + area);
        assertEquals(161.12, area, EPSILON);
    }
    
    @Test
    public void testCircle1() {
        Circle circle = new Circle(21.2);
        double area = circle.area();

        System.out.println("Circle(21.2) area = " + area);
        assertEquals(1411.9574, area, EPSILON);
    }
    
    @Test
    public void testCircle2() {
        Circle circle = new Circle(3.6);
        double area = circle.area();

        System.out.println("Circle(3.6) area = " + area);
        assertEquals(40.715, area, EPSILON);
    }
    
    @Test
    public void testCircle3() {
        Circle circle = new Circle(18);
        double area = circle.area();

        System.out.println("Circle(18) area = " + area);
        assertEquals(1017.876, area, EPSILON);
    }

}
