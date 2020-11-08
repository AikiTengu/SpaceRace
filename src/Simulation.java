import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

    static int budget = 0;
    private ArrayList<U1Rocket> rocketList1P1 = new ArrayList<U1Rocket>();
    private ArrayList<U1Rocket> rocketList1P2 = new ArrayList<U1Rocket>();
    private ArrayList<U2Rocket> rocketList2P1 = new ArrayList<U2Rocket>();
    private ArrayList<U2Rocket> rocketList2P2 = new ArrayList<U2Rocket>();

    public ArrayList<Item> loadItems(String fileName)throws FileNotFoundException {
        File file = new File(fileName);

        Scanner scanner = new Scanner(file);
        ArrayList<Item> itemList = new ArrayList<Item>();

        //Reading Item List
        while (scanner.hasNextLine()) {
            Item item = new Item();
            String line = scanner.nextLine();
            String name = line.substring(0,line.indexOf('='));
            String weightString = line.substring(line.indexOf('=')+1, line.length());
            int weight = Integer.parseInt(weightString);
            item.setName(name);
            item.setWeight(weight);
            item.setLoaded(false);
            itemList.add(item);
        }
        return itemList;
    }

    public ArrayList<U1Rocket> loadU1(ArrayList<Item> items) {
        ArrayList<U1Rocket> u1List = new ArrayList<U1Rocket>();
        boolean everythingLoaded = false;


        while (!everythingLoaded) {
            U1Rocket rocket = new U1Rocket();
            u1List.add(rocket);
            for (Item item : items) {
                //Loading cargo onto rocket
                if (item.isLoaded() == false) {
                    if (rocket.canCarry(item)) {
                        item.setLoaded(true);
                        rocket.Carry(item);
                        everythingLoaded = true;
                    } else {
                        everythingLoaded = false;
                    }

                }
            }
        }
        return u1List;
    }

    public ArrayList<U2Rocket> loadU2(ArrayList<Item> items) {
        ArrayList<U2Rocket> u2List = new ArrayList<U2Rocket>();
        boolean everythingLoaded = false;


        while (!everythingLoaded) {
            U2Rocket rocket = new U2Rocket();
            u2List.add(rocket);
            for (Item item : items) {
                //Loading cargo onto rocket
                if (item.isLoaded() == false) {
                    if (rocket.canCarry(item)) {
                        item.setLoaded(true);
                        rocket.Carry(item);
                        everythingLoaded = true;
                    } else {
                        everythingLoaded = false;
                    }

                }
            }
        }
        return u2List;
    }

    public void RunSimulation(int rocketKind) {
        int totalRocketnumber1 = 0;
        int totalRocketnumber2 = 0;

        //Loading items for phase 1 from file
        ArrayList<Item> itemList = new ArrayList<Item>();
        try {
            itemList = loadItems("phase-1.txt");
        }
        catch (FileNotFoundException e) {
        System.out.println("phase 1 file not found!");
        }

        switch (rocketKind) {
            case 1: {
                rocketList1P1 = loadU1(itemList);
                totalRocketnumber1 = rocketList1P1.size();
                break;
            }
            case 2:
            {
                rocketList2P1 = loadU2(itemList);
                totalRocketnumber1 = rocketList2P1.size();
                break;
            }
        }
        //Printing out the number of rockets for phase 1
        System.out.println("Predicted total number of rockets for phase 1: " + totalRocketnumber1);



        //Loading items for phase 2 from file
        ArrayList<Item> itemList2 = new ArrayList<Item>();
        try {
            itemList2 = loadItems("phase-2.txt");
        }
        catch (FileNotFoundException e) {
            System.out.println("phase 2 file not found!");
        }

            switch (rocketKind) {
                case 1: {
                    rocketList1P2 = loadU1(itemList2);
                    totalRocketnumber2 = rocketList1P2.size();
                    break;
                }
                case 2:
                    {
                        rocketList2P2 = loadU2(itemList2);
                        totalRocketnumber2 = rocketList2P2.size();
                        break;
                    }
                }

        System.out.println("Predicted total number of rockets for phase 2: " + totalRocketnumber2);

        //Running crash on launch/crash on simulation
        int budget = 0;
        int launchcounts = 0;
        switch (rocketKind) {
            case 1: {
                for (U1Rocket rocket : rocketList1P1) {
                    do {
                        launchcounts++;
                    } while (rocket.Launch()||rocket.Land());
                }

                for (U1Rocket rocket : rocketList1P2) {
                    do {
                        launchcounts++;
                    } while (rocket.Launch()||rocket.Land());
                }
                    budget = launchcounts * U1Rocket.cost;
                    System.out.println("Actual total number of U1 rockets for both phases: " + launchcounts);

                break;
            }
            case 2:
            {
                for (U2Rocket rocket : rocketList2P1) {
                    do {
                        launchcounts++;
                    } while (rocket.Launch()||rocket.Land());
                }
                for (U2Rocket rocket : rocketList2P2) {
                    do {
                        launchcounts++;
                    } while (rocket.Launch()||rocket.Land());
                }
                    budget = launchcounts * U2Rocket.cost;
                    System.out.println("Actual total number of U2 rockets for both phases: " + launchcounts);
                    break;
            }
        }

        System.out.println("Total Mars colony budget: " + budget +" mln $");

    }

}

