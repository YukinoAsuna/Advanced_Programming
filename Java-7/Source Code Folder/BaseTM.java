

import java.util.HashMap;
import utm.*;

/**
 * Base Turing Machine configuration manager.
 * @author Shujian Gao, Bohan Shen, Yuan Wang, Zhoumeng Yang, Jin Wang, Zixuan Wen.
 */
public class BaseTM extends TuringMachine {

	/**
	 * The initial location of the header pointer.
	 */
	protected int initialHeadPos;


	/**
	 * instantiate the UTM object.
	 */

	public BaseUTM utm;

	/**
	 * Build the hashmap of the input string.
	 */
	private HashMap<TwoTuple<String, Character>, ThreeTuple<TwoTuple<String, Character>, Integer>> map;

	/**
	 * Constructor of the BaseTM
	 *
	 * @param rulesNumber The number of rules that the machine will have.
	 * @param initialState A string representing the TM's initial state.
	 * @param acceptState A string representing the TM's accept state.
	 * @param rejectState A string representing the TM's reject state.
	 * @param baseUTM The specification of base Universal Turing Machine.
	 */
	public BaseTM(int rulesNumber, String initialState, String acceptState,  String rejectState, BaseUTM baseUTM){
		super(rulesNumber, initialState, acceptState,  rejectState);
		map = new HashMap<>();
		utm = baseUTM;
		utm.loadTuringMachine(this);
	}

	/**
	 * The input string of users to the TM.
	 * @param input
	 */

	public void initiateTM(String input){
		utm.loadInput(input);
	}

	/**
	 * The execution of execution the turing machine.
	 */

	public void execute(){
		for(int i = 0; i < initialHeadPos - 1; i++)
			utm.moveHead(MoveClassical.RIGHT, false);
        // For better fits the animation of the Turing machine movement
		if (utm.isAnimated){
			try {
				Thread.sleep(Config.DELAY);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// Get the initial state of the head
		String currentState = getInitialState();
		HashMap<TwoTuple<String, Character>, ThreeTuple<TwoTuple<String, Character>, Integer>> map = getRule();

		// Judge whether the header is taking accept state or the reject state
		while (!currentState.equals(getAcceptState()) && !currentState.equals(getRejectState())){
			ThreeTuple<TwoTuple<String, Character>, Integer> temp = map.get(new TwoTuple<>(currentState, getTape().get(getHead().getCurrentCell())));
			utm.writeOnCurrentCell(temp.getTuple().getSymbol());
			operateHead(temp.getThird(), utm.isAnimated);
			currentState = temp.getTuple().getState();
			if (utm.isAnimated) utm.updateHeadState(currentState);
		}

		// Get the result of the machine state, whether it is accepted or rejected
		boolean result = currentState.equals(getAcceptState());
		HaltState haltState = result ? HaltState.ACCEPTED : HaltState.REJECTED;
		utm.displayHaltState(haltState);
	}

	/**
	 * Add the rules from .desc file and store it in the variable.
	 * @param rules
	 */
	public void addRules(String[] rules) {
		for (String rule : rules) {
			String[] s = rule.split(","); // s的长度为5，包括q0 1 q1 1 right
			addRule(s[0], s[1].charAt(0), s[2], s[3].charAt(0), getMoveDir(s[4]));
			TwoTuple<String, Character> a = new TwoTuple<>(s[0], s[1].charAt(0));
			Integer dir = s[4].equals("RIGHT") ? 1 : 0; // 1 - right  0 - left
			ThreeTuple<TwoTuple<String, Character>, Integer> b = new ThreeTuple<>(s[2], s[3].charAt(0), dir);
			map.put(a, b);
		}
	}

	/**
	 * Get the rule of the TM from the hashmap.
	 * @return HashMap
	 */
	public HashMap<TwoTuple<String, Character>, ThreeTuple<TwoTuple<String, Character>, Integer>> getRule()
	{
		return map;
	}

	/**
	 * Get the move direction from the input.
	 * @param move
	 * @return move state
	 */
	protected Move getMoveDir(String move){
		return move.equals("RIGHT") ? MoveClassical.RIGHT : MoveClassical.LEFT;
	}

	/**
	 * Get the next move direction of the head
	 * @param move
	 * @param animation
	 */
	public void operateHead(Integer move, boolean animation){
		if(move.equals(1))
			utm.moveHead(MoveClassical.RIGHT, animation);
		else
			utm.moveHead(MoveClassical.LEFT, animation);
	}
}
