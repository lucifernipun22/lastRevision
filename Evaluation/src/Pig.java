public class Pig extends Animal {
    @Override
    public String getColor(String color) {
        System.out.println("Pig is "+color+" in color");
        return null;
    }

    @Override
    public String getSound(String sound) {
        System.out.println("Pig makes" +sound+"sound");
        return null;
    }
}
