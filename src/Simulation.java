import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {


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
        boolean rocketfull = true;
        U1Rocket rocket;

        for (Item item : items) {
           //Checking if it is necessary to build new rocket
           if (rocketfull) {
               rocket = new U1Rocket();
               rocketfull = false;
           }
           //Loading cargo onto rocket
           if (item.isLoaded()==false) {
                if (rocket.canCarry(item)) {
                    item.setLoaded(true);
                    rocket.Carry(item);
                }
                else {
                    rocketfull = true;
                    u1List.add(rocket);
                }
            }
        }
        return u1List;
    }

    public ArrayList<U2Rocket> loadU2(ArrayList<Item> items) {
        ArrayList<U2Rocket> u2List = new ArrayList<U2Rocket>();

        return u2List;
    }

    public int RunSimulation() {

        //Loading items for phase 1 from file
        ArrayList<Item> itemList = new ArrayList<Item>();
        try {
            itemList = loadItems("phase-1.txt");
        }
        catch (FileNotFoundException e) {
        System.out.println("phase 1 file not found!");
        }

        loadU1(itemList);
        //Test output of loaded items list
        for (Item item : itemList) {
            System.out.println(item.getName()+" "+item.getWeight()+" "+item.isLoaded());
        }

        return 0;
    }

}

