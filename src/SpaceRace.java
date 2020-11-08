public class SpaceRace {
    public static void main(String[] args) {

        int total = 0;
        Simulation sim1 = new Simulation();
        System.out.println("Simulating Mars Colonization with U1 Rockets: ");
        sim1.RunSimulation(1);
        System.out.println("Simulating Mars Colonization with  of U2 Rockets: ");
        sim1.RunSimulation(2);

    }
}
