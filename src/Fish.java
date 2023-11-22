public class Fish extends Animal {

    private int finsCount;

    public Fish(String name, int age, String habitat, int finsCount) {
        super(name, age, habitat);
        this.finsCount = finsCount;
    }
    public int getFinsCount() {
        return finsCount;
    }
    @Override
    public void eat() {
        System.out.println("Їсть дрібних тварин і рослини");
    }

    @Override
    public void reproduce() {
        System.out.println("Розмножується ікрометанням");
    }
}
