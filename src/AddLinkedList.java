/**
 * This AddLinkedList class implements a “AddLinkedList”
 * which adds two linked lists and outputs a result
 * 
 * @author maneeshavenigalla maneesha24@vt.edu
 * @version 1.0
 *
 */
public class AddLinkedList {

    private static Node head;

    /**
     * This Node class implements a “Node”
     * which represents indv node in the list
     * @author maneeshavenigalla maneesha24@vt.edu
     * @version 1.0
     */
    private static class Node {
        private int value;
        private Node next;

        /**
         * @param value value to be
         * be assigned
         */
        public Node(int value) {
            this.value = value;

        }
    }

    /**
     * @param node node to be appended
     * takes the value of the node to be appended
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
     * @param node node to be reverse
     * takes the value of the linked list
     * @return nextNodes
     * recursively reverses all the nodes in the list
     */
    public static Node reverse(Node node) {
        if (node == null || node.next == null) {
            return node;
        }

        Node nextNodes = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return nextNodes;
    }


    /**
     * @param firstNumber firstnum
     * @param secondNumber secondnum
     * takes the value of the numbers to be added
     * @return initialHead
     * returns the addition of two linked lists
     */
    public String addLinkedLists(Node firstNumber, Node secondNumber) {
        
        int carryVal = 0;
        int sum = 0;
        String result = "";
        //Step 1 - Loop till the end of two numbers
        while (firstNumber != null || secondNumber != null) {
            
            // Step 2 - Add one digit from each lsit and carry if present
            sum = carryVal + (firstNumber != null ? firstNumber.value : 0)
                + (secondNumber != null ? secondNumber.value : 0);
            
            // Step 3 - Update the value of carry
            if (sum >= 10) {
                carryVal = 1;
            } 
            else 
            {
                carryVal = 0;
            }
            
            if (firstNumber != null) 
            {
                firstNumber = firstNumber.next;
            }
            if (secondNumber != null) 
            {
                secondNumber = secondNumber.next;
            }
            
            // Step 3 - Update the value of sum
            sum = sum % 10;
            
            // Step 4 - Store each digit of sum
            result = sum + result;
        }
        
        if (carryVal > 0) {
            result = Integer.toString(carryVal) + result;
        }
        
        return result;
    }


    /**
     * @param firstString firstnum
     * @param secondString secondnum
     * takes the value of the strings to be added
     *  as string
     * @return string output from the output result function
     */
    public static String main(String firstString, String secondString) {
        

        AddLinkedList list = new AddLinkedList();

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

        firstNum = reverse(firstNum);

        secondNum = reverse(secondNum);

        String sum = list.addLinkedLists(secondNum, firstNum);

        return sum;

    }

}