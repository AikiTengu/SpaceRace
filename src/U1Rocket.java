public class U1Rocket extends Rocket{
    public static int cost = 100;

    public U1Rocket() {
        carryCapacity = 8000;
        cargoCarried = 0;
    }

    @Override
    public  boolean Launch() {
        double explosion = 5.0 * this.cargoCarried / carryCapacity;
        return Math.random() * 100 < explosion;
    }

    @Override
    public boolean Land() {
        double explosion = 1.0 * this.cargoCarried / carryCapacity;
        return Math.random() * 100 < explosion;
    }
}
