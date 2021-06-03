import java.math.BigInteger;
/**
 * This ExpLinkedList class implements a “ExpLinkedList”
 * which gives power of two linked lists and outputs a 
 * result
 * @author maneeshavenigalla maneesha24@vt.edu
 * @version 1.0
 */
public class ExpLinkedList {
    private static Node head;

    private static String result = "";

    /**
     * This Node class implements a “Node”
     * which represents indv node in the list
     * 
     * @author maneeshavenigalla maneesha24@vt.edu
     * @version 1.0
     *
     */
    private static class Node {
        private int value;
        private Node next;

        /**
         * @param value value to be assigned
         */
        public Node(int value) {
            this.value = value;

        }
    }
    
    /**
     * @param node node to be appended
     * at the end of the linked list
     */
    public void appendAtTheEnd(Node node) {

        if (head == null) {
            head = node;
        }
        else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = node;
        }
    }
    
    /**
     * @param resultNode
     *            takes the value of the output node
     * @return result
     *         returns the string value of the output node
     */
    public String getValue(Node resultNode) {
        result = "";
        Node temp = resultNode;
        while (temp != null) {
            result += Integer.toString(temp.value);
            temp = temp.next;
        }

        return result;
    }
    

    /**
     * @param firstNumber firstnum to be added
     * @param secondNumber secondnum to be added
     * value of the numbers to be added
     * @return initialHead
     * returns the value of the head
     */
    public String expLinkedLists(Node firstNumber, Node secondNumber) {
        BigInteger b1;
        
        b1 = new BigInteger(getValue(secondNumber));
        int exponent = Integer.parseInt(getValue(firstNumber));
  
        BigInteger expresult = b1.pow(exponent);
        return expresult.toString();
    }
    
    /**
     * @param firstString base of the value
     * @param secondString power of the exp
     * takes the value of the numbers to be powered
     * @return string output from the output result function
     */
    public static String main(String firstString, String secondString) {

        ExpLinkedList list = new ExpLinkedList();

        result = "";

        Node firstNum = new Node(Character.getNumericValue(firstString.charAt(
            0)));
        list.appendAtTheEnd(firstNum);

        for (int i = 1; i < firstString.length(); i++) {
            list.appendAtTheEnd(new Node(Character.getNumericValue(firstString
                .charAt(i))));
        }

        head = null;
        Node secondNum = new Node(Character.getNumericValue(secondString.charAt(
            0)));
        list.appendAtTheEnd(secondNum);
        for (int j = 1; j < secondString.length(); j++) {
            list.appendAtTheEnd(new Node(Character.getNumericValue(secondString
                .charAt(j))));
        }

        return list.expLinkedLists(firstNum, secondNum);
    }


}
