

import utmeditor.UTMController;
import javax.swing.*;

/**
 * The controller for the Left-Reset Turing Machine configuration manager.
 * It implements the UTMController interface and manages the base UTM object and loads Turing machine and executes it on the input string.
 * It also sets animation and displays the UTM window.
 *
 * @author Shujian Gao, Bohan Shen, Yuan Wang, Zhoumeng Yang, Jin Wang, Zixuan Wen.
 *
 */
public class ModifiedUTMController implements UTMController {
    /** The base UTM object used for the LRTM configuration. */
    BaseUTM baseUTM;

    /**
     Constructor for ModifiedUTMController class. Initializes the base UTM object.
     */
    public ModifiedUTMController(){
        baseUTM = new BaseUTM();
    }

    /**
     Sets the animation of the UTM.
     @param animation A boolean value indicating whether animation is enabled.
     */
    public void setAnimation(boolean animation){
        baseUTM.setAnimated(animation);
    }

    /**
     Displays the UTM window.
     */
    public void displayWindow(){
        baseUTM.display();
        baseUTM.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     Loads the Turing machine from a file path.
     @param filePath A string value indicating the file path to load the Turing machine from.
     */
    @Override
    public void loadTuringMachineFrom(String filePath) {
        baseUTM.createTuringMachineFrom(filePath);
    }

    /**
     Runs the loaded Turing machine on the input string.
     @param input A string value indicating the input for the Turing machine.
     */
    @Override
    public void runUTM(String input) {
        baseUTM.executeTM(input);
    }
}
