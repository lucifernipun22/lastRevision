public  class Eagle extends Animal{
    @Override
    public String getColor(String color) {
        System.out.println("Eagle is"+color+" in color");
        return null;
    }

    @Override
    public String getSound(String sound) {
        System.out.println("Eagle makes"+sound+" sound");
        return null;
    }

    public String fly(String fly) {
        System.out.println("Eagle can fly at "+fly+" from the ground");
        return null;
    }
}
