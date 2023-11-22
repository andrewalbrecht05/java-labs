public class Mammal extends Animal {

    public boolean hasFur;

    public Mammal(String name, int age, String habitat, boolean hasFur) {
        super(name, age, habitat);
        this.hasFur = hasFur;
    }

    @Override
    public void eat() {
        System.out.println("Їсть рослинну або тваринну їжу");
    }

    @Override
    public void reproduce() {
        System.out.println("Розмножується статевим шляхом");
    }
}
