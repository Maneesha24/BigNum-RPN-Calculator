/**
 * This Node class implements a “Node”
 * which implements a node to be
 * pushed into the stack
 * @author maneeshavenigalla maneesha24@vt.edu
 * @version 1.0
 */
public class Node {
    /**
     * contains value of the node
     */
    private String data;
    /**
     * contains value of the node
     * to be assigned
     */
    private Node nextNode;

    /**
     * @param data value of node
     * assigns the value of node to be assigned
     */
    public Node(String data) {
        this.data = data;
        this.nextNode = null;
    }


    /**
     * @return data 
     * returns the value of node
     */
    public String getValue() {
        return data;
    }

    /**
     * @return node 
     * returns the value of next node
     */
    public Node getNextNode() {
        return nextNode;
    }

    /**
     * @param nextNode value of node 
     * sets the next node to the current node
     */
    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}
