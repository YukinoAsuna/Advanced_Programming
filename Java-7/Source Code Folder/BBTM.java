

import utm.*;

/**
 * Busy Beaver Turing Machine configuration manager.
 * This class is responsible for managing the configuration of a Busy Beaver Turing Machine.
 * It extends the BaseTM class and overrides some of its methods to implement the specific
 * functionality required for a Busy Beaver TM.
 *
 * @author Shujian Gao, Bohan Shen, Yuan Wang, Zhoumeng Yang, Jin Wang, Zixuan Wen.
 * */
public class BBTM extends BaseTM {

	/**
	 The constructor for a Busy Beaver TM.
	 @param rulesNumber The number of rules in the Turing Machine.
	 @param initialState The initial state of the Turing Machine.
	 @param acceptState The accept state of the Turing Machine.
	 @param rejectState The reject state of the Turing Machine.
	 @param baseUTM The base Universal Turing Machine.
	 */

	public BBTM(int rulesNumber, String initialState, String acceptState,  String rejectState, BaseUTM baseUTM) {
		super(rulesNumber, initialState, acceptState, rejectState, baseUTM);
		initialHeadPos = 10;
	}


	/**
	 Overrides the getMoveDir method in BaseTM to return the specific Move object for a Busy Beaver TM.
	 @param move The way that the head should move.
	 @return The Move object for the given move.
	 */

	@Override
	protected Move getMoveDir(String move) {
		return move.equals("RIGHT") ? MoveBBTM.RIGHT : MoveBBTM.LEFT;
	}

	/**
	 Overrides the initiateTM method in BaseTM to initialize the tape with a specific input for a Busy Beaver TM.
	 @param input The input to initialize the tape with.
	 */
	@Override
	public void initiateTM(String input) {
		super.initiateTM("00000000000000000000");
	}
}
