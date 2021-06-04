/**
 * This DefinedStack class implements a “DefinedStack”
 * which implements a custom stack class
 * @author maneeshavenigalla maneesha24@vt.edu
 * @version 1.0
 */
public class DefinedStack {
    /**
     * contains value of the size of stack
     */
    private static int stacksize = 0;
    /**
     * contains value of the the initial node
     */
    private static Node initialNode;
      
    /**
     * @param data value to be added
     * takes the value as the input to be pushed to the stack
     */
    public static void push(String data) {
        Node newNode = new Node(data);
        newNode.setNextNode(initialNode);
        initialNode = newNode;
        stacksize++;
    }


    /**
     * removes the value from the stack and returns the removed value
     * @return the removed value from the stack
     */
    public static String pop() {
        Node topNode = initialNode;
        initialNode = initialNode.getNextNode();
        stacksize--;
        return topNode.getValue();
    }
    
    /**
     * calculates the size of stack
     * @return the size of stacksize
     */
    public static int getStackSize() {
        return stacksize;
    }
    
    /**
     * empties the stack
     */
    public static void emptyStack() {
        for (int i = 0; i < stacksize; i++) {
            pop();
        }
    }
}
