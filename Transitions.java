public class Transitions<T> {
    char symbol;
    State<T> q1;
    State<T> q2;
    /**
     * 
     * @param symbol The symbol that will create a transition
     * @param q1 The initial state of the transition
     * @param q2 The final state of the transition
     */
    public Transitions(char symbol, State<T> q1, State<T> q2) {
        super();
        this.symbol = symbol;
        this.q1 = q1;
        this.q2 = q2;
    }
    /**
     * 
     * @return Returns the symbol of the transition
     */
    public char getSymbol() {
        return this.symbol;
    }
    /**
     * 
     * @param symbol Sets the symbol for the transition
     */
    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
    /**
     * 
     * @return Returns the initial state of the transition
     */
    public State<T> getQ1() {
        return this.q1;
    }
    /**
     * 
     * @param q1 Sets the initial state for the transaction
     */
    public void setQ1(State<T> q1) {
        this.q1 = q1;
    }
    /**
     * 
     * @return Returns the final state of the transition
     */
    public State<T> getQ2() {
        return this.q2;
    }
    /**
     * 
     * @param q2 Sets the final state for the transaction
     */
    public void setQ2(State<T> q2) {
        this.q2 = q2;
    }

}