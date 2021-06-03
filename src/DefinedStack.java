/**
 * @author maneeshavenigalla maneesha24@vt.edu
 * @version 1.0
 *
 */
public class DefinedStack {
    static private Node initialNode;

    /**
     * @param data
     *            takes the value of data to be added
     *            takes the value as the input to be pushed to the stack
     */
    public static void push(String data) {
        Node newNode = new Node(data);
        newNode.setNextNode(initialNode);
        initialNode = newNode;
    }


    /**
     * removes the value from the stack and returns the removed value
     * 
     * @return the removed value from the stack
     */
    public static String pop() {
        Node topNode = initialNode;
        initialNode = initialNode.getNextNode();
        return topNode.getValue();
    }
}
