import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @param <T>
 */

public class State<T> {
    List<Transitions<T>> transitions;
    String type;
    T element;
    boolean isVisited;

    /**
     * 
     * @return Returns the possible transitions from a state.
     */
    public List<Transitions<T>> getTransitions() {
        return this.transitions;
    }
    /**
     * 
     * @param transitions Sets the transitions on a list
     */
    public void setTransitions(List<Transitions<T>> transitions) {
        this.transitions = transitions;
    }
    /**
     * 
     * @return Returns if a state is initial or final
     */
    public String getType() {
        return this.type;
    }
    /**
     * 
     * @param type Sets the type of the state
     */
    public void setType(String type) {
        this.type = type;
    }
    /**
     * 
     * @return Returns an element of the NFA
     */
    public T getElement() {
        return this.element;
    }
    /**
     * 
     * @param element Sets an element on the NFA
     */
    public void setElement(T element) {
        this.element = element;
    }
    /**
     * 
     * @return Returns the value of isVisited
     */
    public boolean getIsVisited() {
        return this.isVisited;
    }
    /**
     * 
     * @param isVisited Sets the value of isVisited
     */
    public void setIsVisited(boolean isVisited) {
        this.isVisited = isVisited;
    }
    /**
     * 
     * @param isVisited  Determines if the state is visited or not
     * @return Returns if the state is visited
     */
    public boolean isVisited(boolean isVisited) {
        return isVisited;
    }
    /**
     * 
     * @param trans Adds a transition to the list of transitions
     */
    public void newTransition(Transitions<T> trans) {
        transitions.add(trans);
    } 

}