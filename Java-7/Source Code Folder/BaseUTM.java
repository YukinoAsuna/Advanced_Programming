

import utm.UniversalTuringMachine;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Base Universal Turing Machine configuration manager.
 * This class is responsible for creating a Turing Machine from a file and executing it.
 * It uses a UniversalTuringMachine as its parent class.
 * It also contains a boolean variable isAnimated, which indicates whether the Turing Machine execution should be animated.
 *
 * @author Shujian Gao, Bohan Shen, Yuan Wang, Zhoumeng Yang, Jin Wang, Zixuan Wen.
 */
public class BaseUTM extends UniversalTuringMachine {
    /**
     * The boolean value of whether it is animated.
     */
    public boolean isAnimated = false;

    /**
     * Instantiate the BaseTM
     */
    private BaseTM tm;

    /**
     * Create a Turing Machine from a file
     * @param filePath the path of the file containing the Turing Machine configuration
     */
    public void createTuringMachineFrom(String filePath){
        String initialState = "", acceptState = "", rejectState = "", variant = "", rulesRecord = "";
        try (Scanner sc = new Scanner(new FileReader(filePath))) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if(line.equals("") || line.charAt(0) == '#')
                    continue;
                String[] contents = line.split("=");
                switch (contents[0]) {
                    case "initialState":
                        initialState = contents[1];
                        break;
                    case "acceptState":
                        acceptState = contents[1];
                        break;
                    case "rejectState":
                        rejectState = contents[1];
                        break;
                    case "variant":
                        variant = contents[1];
                        break;
                    case "rules":
                        rulesRecord = contents[1];
                        break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // split the rules and create the Turing Machine based on the variant
        String[] rules = rulesRecord.split("<>");
        switch (variant) {
            case "CLASSICAL":
                tm = new ClassicalTM(rules.length, initialState, acceptState, rejectState, this);
                break;
            case "BUSY_BEAVER":
                tm = new BBTM(rules.length, initialState, acceptState, rejectState, this);
                break;
            case "LEFT_RESET":
                tm = new LRTM(rules.length, initialState, acceptState, rejectState, this);
                break;
            default:
                System.out.println("Wrong file");
                return;
        }
        tm.addRules(rules);
    }

    /**
     * Execute the Turing Machine with the given input
     * @param input the input string for the Turing Machine
     */
    public void executeTM(String input){
        BaseTM baseTM = (BaseTM) getTuringMachine();
        baseTM.initiateTM(input);
        baseTM.execute();
    }

    /**
     * Set the isAnimated variable to the given value
     * @param animated true if the Turing Machine execution should be animated, false otherwise
     */
    public void setAnimated(boolean animated){
        isAnimated = animated;
    }
}

