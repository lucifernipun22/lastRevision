public class AnimalTestDrive  {

    public static void main(String[] args) {
        Pig pig = new Pig();
        pig.getColor("white");
        pig.getSound("wee wee");
        Eagle eagle = new Eagle();
        eagle.getColor("brown");
        eagle.getSound("quack quack");
        eagle.fly("10ft");
    }
}
