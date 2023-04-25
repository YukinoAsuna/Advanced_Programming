

import java.util.Objects;

/**
 * Two-element tuple for hashmap
 * @author Shujian Gao, Bohan Shen, Yuan Wang, Zhoumeng Yang, Jin Wang, Zixuan Wen.
 * @param <String> The state
 * @param <Character> The tuple
 */

class TwoTuple<String, Character> {

    /** The state. */
    private String state;
    /** The symbol. */
    private Character symbol;

    /**
     * The constructor of TwoTuple
     * @param a The input state.
     * @param b The input symbol.
     */
    public TwoTuple(String a, Character b) {
        state = a;
        symbol = b;

    }

    /**
     * Get the state value of the tuple.
     * @return The state.
     */
    public String getState() {
        return state;
    }

    /**
     * Get the symbol value of the tuple.
     * @return The symbol.
     */
    public Character getSymbol() {
        return symbol;
    }

    /**
     * Judge if the values of this Two-element tuple equal to the input tuple.
     * @param obj The input tuple.
     * @return Boolean.
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        TwoTuple<String, Character> o = (TwoTuple<String, Character>) obj;
        return this.getState().equals(o.getState()) && this.getSymbol().equals(o.getSymbol());

    }

    /**
     * Rewrite equals as well as hashCode, because hashCode for the same object is always the same.
     * @return The hash value of the input values.
     */
    public int hashCode() {
        //Call the Objects class, which is a subclass of the Object class
        return Objects.hash(state, symbol);
    }


}