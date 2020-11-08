import java.util.Random;

public class U1Rocket extends Rocket{
    public static int cost = 100;

    public U1Rocket() {
        carryCapacity = 8000;
        cargoCarried = 0;
    }

    @Override
    public  boolean Launch() {
        int explosion = 5 * this.cargoCarried / carryCapacity;
        Random r = new Random();
        return (r.nextInt(100) < explosion);
    }

    @Override
    public boolean Land() {
        int explosion = 1 * this.cargoCarried / carryCapacity;
        Random r = new Random();
        return (r.nextInt(100) < explosion);
    }
}
