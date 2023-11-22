public class Reptile extends Animal {

    private String scalesColor;

    public Reptile(String name, int age, String habitat, String scalesColor) {
        super(name, age, habitat);
        this.scalesColor = scalesColor;
    }
    public String getScalesColor() {
        return scalesColor;
    }
    @Override
    public void eat() {
        System.out.println("Їсть безхребетних, дрібних хребетних і рослини");
    }

    @Override
    public void reproduce() {
        System.out.println("Розмножується яйцеживородінням");
    }
}
