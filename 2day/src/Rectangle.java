public class Rectangle extends Shape{

    public int length;
    public int breadth;


    @Override
    public int calculateArea() {
        return 0;
    }
    public Rectangle(int length , int breadth){
        this.length = length;
        this.breadth = breadth;
        int calculateArea = length*breadth;
        System.out.println("Area of rectangle: "+calculateArea);
    }
}
