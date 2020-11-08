import java.util.Random;

public class U2Rocket extends Rocket{
    public static int cost = 120;

    public U2Rocket() {
        carryCapacity = 11000;
        cargoCarried = 0;
    }

    @Override
    public  boolean Launch() {
        int explosion = 4 * this.cargoCarried / carryCapacity;
        Random r = new Random();
        return (r.nextInt(100) < explosion);
    }

    @Override
    public boolean Land() {
        int explosion = 8 * this.cargoCarried / carryCapacity;
        Random r = new Random();
        return (r.nextInt(100) < explosion);
    }
}
