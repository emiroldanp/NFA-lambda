import java.util.ArrayList;
import java.util.List;

public class State<T> {
    List<Transitions<T>> transitions;
    String type;
    T element;
    boolean isVisited;

    public List<Transitions<T>> getTransitions() {
        return this.transitions;
    }

    public void setTransitions(List<Transitions<T>> transitions) {
        this.transitions = transitions;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public T getElement() {
        return this.element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public boolean getIsVisited() {
        return this.isVisited;
    }

    public void setIsVisited(boolean isVisited) {
        this.isVisited = isVisited;
    }

    public boolean isVisited(boolean isVisited) {
        return isVisited;
    }

    public void newTransition(Transitions<T> trans) {
        transitions.add(trans);
    } 

}