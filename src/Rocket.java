import java.util.ArrayList;

public class Rocket implements SpaceShip{

    protected static int carryCapacity;
    protected int cargoCarried;

    protected ArrayList<Item> cargo;

    public Rocket() {
        this.cargoCarried = 0;
        this.cargo = new ArrayList<Item>();
    }

    @Override
    public  boolean Launch() {
        return true;
    }

    @Override
    public boolean Land() {
        return true;
    }

    @Override
    public boolean canCarry(Item item) {
        return carryCapacity >= (this.cargoCarried + item.getWeight());
    }

    @Override
    public void Carry(Item item) {
        cargo.add(item);
        this.cargoCarried += item.getWeight();
    }
}
