

/**
 * A three-element tuple for hashmap that stores a state, a symbol, and a direction.
 * The first two elements are stored in a TwoTuple object.
 * @param <T> The type of the first element in the TwoTuple object.
 * @param <Integer> The type of the third element in the tuple.
 * @author Shujian Gao, Bohan Shen, Yuan Wang, Zhoumeng Yang, Jin Wang, Zixuan Wen.
 */
public class ThreeTuple<T, Integer> {

    /** The state and symbol. */
    private TwoTuple<String, Character> tuple;
    /** The direction. */
    private Integer dir;

    /**
     * Constructs a new ThreeTuple object with the specified state, symbol, and direction.
     * @param a The state.
     * @param b The symbol.
     * @param dir_ The direction.
     */
    public ThreeTuple(String a, Character b, Integer dir_){
        tuple = new TwoTuple<String, Character>(a, b);
        dir = dir_;
    }

    /**
     * Returns the TwoTuple object containing the state and symbol.
     * @return The TwoTuple object.
     */
    public TwoTuple<String, Character> getTuple() {
        return tuple;
    }

    /**
     * Returns the direction.
     * @return The direction.
     */
    public Integer getThird() {
        return dir;
    }

}