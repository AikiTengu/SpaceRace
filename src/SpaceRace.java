public class SpaceRace {
    public static void main(String[] args) {

        int total = 0;
        Simulation sim1 = new Simulation();
        total = sim1.RunSimulation();
        System.out.println("Total Mars expidition budget is: " + total);

    }
}
