public class SpaceRace {
    public static void main(String[] args) {

        int total = 0;
        Simulation sim1 = new Simulation();
        System.out.println("Simulating a non-crashable launch of U1 Rockets: ");
        sim1.RunSimulation(1);
        System.out.println("Simulating a non-crashable launch of U2 Rockets: ");
        sim1.RunSimulation(2);

    }
}
