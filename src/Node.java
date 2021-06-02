public class Node {
	String data;
    private Node nextNode;

    public Node(String data2) {
        this.data = data2;
        this.nextNode = null;
    }
    
    public String getValue() {
    	return data;
    }
    
    public Node getNextNode() {
    	return nextNode;
    }
    
    public void setNextNode(Node nextNode) {
    	this.nextNode = nextNode;
    }
}
