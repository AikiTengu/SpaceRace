public class U2Rocket extends Rocket{
    public static int cost = 120;

    public U2Rocket() {
        carryCapacity = 11000;
        cargoCarried = 0;
    }

    @Override
    public  boolean Launch() {
        double explosion = 4.0 * this.cargoCarried / carryCapacity;
        return Math.random() * 100 < explosion;
    }

    @Override
    public boolean Land() {
        double explosion = 8.0 * this.cargoCarried / carryCapacity;
        return Math.random() * 100 < explosion;
    }
}
