public class Square extends Shape {

    public int side;
    @Override
    public int calculateArea() {
        return 0;
    }
    public Square(int side){

        this.side = side;
        int sideOfSquare= side*side;
        System.out.println("Side of square is: "+sideOfSquare);


    }
}
