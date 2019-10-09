public class Transitions<T> {
    char symbol;
    State<T> q1;
    State<T> q2;

    public Transitions(char symbol, State<T> q1, State<T> q2) {
        super();
        this.symbol = symbol;
        this.q1 = q1;
        this.q2 = q2;
    }

    public char getSymbol() {
        return this.symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public State<T> getQ1() {
        return this.q1;
    }

    public void setQ1(State<T> q1) {
        this.q1 = q1;
    }

    public State<T> getQ2() {
        return this.q2;
    }

    public void setQ2(State<T> q2) {
        this.q2 = q2;
    }

}