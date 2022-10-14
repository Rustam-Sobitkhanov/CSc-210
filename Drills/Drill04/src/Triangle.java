public class Triangle extends Shape{
    private double length;
    private double width;

    public Triangle(double width, double length){
        this.length = length;
        this.width = width;
    }

    @Override
    public double area(){
        return 0.5 * width * length;
    }
}
