/**
 * @author maneeshavenigalla maneesha24@vt.edu
 * @version 1.0
 *
 */
public class DefinedStack {
    static private Node initialNode;
    static private int stackSize = 0;

/**
 * @param data
 * takes the value of data to be added
 * takes the value as the input to be pushed to the stack
 *Increments the value of stacksize by 1
 */
    public static void push(String data) {
        Node newNode = new Node(data);
        newNode.setNextNode(initialNode);
        initialNode = newNode;
        stackSize++;
    }


/**
 * removes the value from the stack and returns the removed value
 * Decrements the value of stacksize by 1
 * @return the removed value from the stack
 */
    public static String pop() {
        Node topNode = initialNode;
        if(initialNode != null) {
        	initialNode = initialNode.getNextNode();
        	return topNode.getValue();
        }
        stackSize--;
        return null;
    }
}