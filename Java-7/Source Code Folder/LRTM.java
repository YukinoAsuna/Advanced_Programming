

import utm.*;

/**
 * A class that represents a Left-Reset Turing Machine configuration manager.
 * This class extends the BaseTM class and overrides the getMoveDir() method to return
 * the appropriate move direction based on the input string "RIGHT" or "RESET".
 * This class also overrides the nextMove() method to move the head to the right or reset
 * it based on the input move integer.
 * @author Shujian Gao, Bohan Shen, Yuan Wang, Zhoumeng Yang, Jin Wang, Zixuan Wen.
 */
public class LRTM extends BaseTM {
	/**
	 * * Constructor that takes in the number of rules, initial state, accept state,
	 * reject state, and a BaseUTM object
	 * @param rulesNumber  The number of rules in the Turing Machine.
	 * @param initialState The initial state of the Turing Machine.
	 * @param acceptState  The accept state of the Turing Machine.
	 * @param rejectState  The reject state of the Turing Machine.
	 * @param baseUTM      The BaseUTM object that this LRTM object belongs
	 */
	public LRTM(int rulesNumber, String initialState, String acceptState,  String rejectState, BaseUTM baseUTM) {
		super(rulesNumber, initialState, acceptState, rejectState, baseUTM);
		initialHeadPos = 0;
	}

	/**
	 * Method that returns the appropriate move direction based on the input string "RIGHT" or "RESET".
	 * @param move The input string representing the direction of the move.
	 * @return The appropriate MoveLRTM enum value based on the input string.
	 */
	@Override
	protected Move getMoveDir(String move) {
		return move.equals("RIGHT") ? MoveLRTM.RIGHT : MoveLRTM.RESET;
	}


	/**
	 * Method that moves the head to the right or resets it based on the input move integer.
	 * @param move The input integer representing the move direction.
	 * @param animation A boolean value indicating whether animation is enabled.
	 */
	@Override
	public void operateHead(Integer move, boolean animation){
		if(move.equals(1))
			utm.moveHead(MoveClassical.RIGHT, animation);
		else {
			if(animation){
				try {
					Thread.sleep(Config.DELAY);
				}
				catch (InterruptedException ex){
					System.out.println(ex);
				}
			}
			utm.getTuringMachine().getHead().reset();
		}
	}
}
