public interface SpaceShip {
    boolean  Launch();
    boolean  Land();
    boolean canCarry(Item item);
    void Carry(Item item);
}
