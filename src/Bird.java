public class Bird extends Animal {

    private String wingsColor;

    public Bird(String name, int age, String habitat, String wingsColor) {
        super(name, age, habitat);
        this.wingsColor = wingsColor;
    }
    public String getWingsColor(){
        return wingsColor;
    }
    @Override
    public void eat() {
        System.out.println("Їсть насіння, комах або фрукти");
    }

    @Override
    public void reproduce() {
        System.out.println("Розмножується кладкою яєць");
    }
}
