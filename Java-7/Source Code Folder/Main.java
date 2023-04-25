

import utmeditor.UTMEditor;
/**
 * The main class for running the Left-Reset Turing Machine.
 * This is a description of a command line interface for loading a Turing machine description and input.
 * It also allows for the specification of whether display an animation window.
 * @author Shujian Gao, Bohan Shen, Yuan Wang, Zhoumeng Yang, Jin Wang, Zixuan Wen.
 */
public class Main {
    public static void main(String[] args) {
        // initialize the controller
        ModifiedUTMController controller = new ModifiedUTMController();

        // Identify the input terminal of the UTM, if it exists exception
        if (args.length == 0) {
            controller.setAnimation(true);
            controller.displayWindow();
            UTMEditor utmEditor = new UTMEditor();
            utmEditor.setUTMController(controller);
        }else {
            // Judge the format of the input information
            if (args.length != 3) {
                System.out.println("Please input in the format: java -jar practical1-ID.jar \"desc_absPath\" "
                        + "\"input\" [--animation/--noanimation]");
                System.exit(0);
            }
            // If the user needs the animation of the tape moving
            if (args[2].equals("--animation")) {
                controller.setAnimation(true);
                controller.displayWindow();
            }
            // If the user only needs the result of the turing machine
            else if(!args[2].equals("--noanimation")){
                System.out.println("Please input in the format: java -jar practical1-ID.jar \"desc_absPath\" "
                        + "\"input\" [--animation/--noanimation]");
                System.exit(0);
            }
            controller.loadTuringMachineFrom(args[0]);
            controller.runUTM(args[1]);
        }
    }
}
