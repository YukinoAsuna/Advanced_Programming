


/**
 * A class representing a Classical Turing Machine configuration manager.
 * It extends the BaseTM class and provides specific implementation for a classical Turing Machine.
 * @author Shujian Gao, Bohan Shen, Yuan Wang, Zhoumeng Yang, Jin Wang, Zixuan Wen.
 */
public class ClassicalTM extends BaseTM {
	/**
	 Constructor for creating a ClassicalTM object.
	 @param rulesNumber the number of rules in the transition function of the Turing Machine
	 @param initialState the initial state of the Turing Machine
	 @param acceptState the accept state of the Turing Machine
	 @param rejectState the reject state of the Turing Machine
	 @param baseUTM the underlying BaseUTM object of the Turing Machine
	 */
	public ClassicalTM(int rulesNumber, String initialState, String acceptState,  String rejectState, BaseUTM baseUTM) {
		super(rulesNumber, initialState, acceptState, rejectState, baseUTM);
		initialHeadPos = 0;
	}
}
