public class Amphibian extends Animal {

    public boolean canLiveOnLand;

    public Amphibian(String name, int age, String habitat, boolean canLiveOnLand) {
        super(name, age, habitat);
        this.canLiveOnLand = canLiveOnLand;
    }

    @Override
    public void eat() {
        System.out.println("Їсть безхребетних і дрібних хребетних");
    }

    @Override
    public void reproduce() {
        System.out.println("Розмножується яйцеживородінням");
    }
}
