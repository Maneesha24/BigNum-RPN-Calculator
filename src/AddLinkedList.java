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
         * @param value
         *            takes the value of data to be assigned
         */
        public Node(int value) {
            this.value = value;

        }
    }

    /**
     * @param node
     *            takes the value of the node to be appended
     *            at the end of the linked list
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
    public String outputResult(Node resultNode) {
        Node temp = resultNode;
        while (temp != null) {
            result += Integer.toString(temp.value);
            temp = temp.next;
        }

        return result;
    }


    /**
     * @param node
     *            takes the value of the linked list
     * @return nextNodes
     *         recursively reverses all the nodes in the list
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
     * @param firstNumber
     *            secondNumber
     *            takes the value of the numbers to be added
     * @return initialHead
     *         returns the value of the head
     */
    public Node addLinkedLists(Node firstNumber, Node secondNumber) {
        Node initialHead = null;
        int carryVal = 0;

        Node tempNodeForIteration = null;
        int sumResult = 0;

        int count = 0;
        while (firstNumber != null || secondNumber != null) {
            count++;
            sumResult = carryVal;
            if (firstNumber != null) {
                sumResult = sumResult + firstNumber.value;
                firstNumber = firstNumber.next;
            }

            if (secondNumber != null) {
                sumResult = sumResult + secondNumber.value;
                secondNumber = secondNumber.next;
            }

            carryVal = sumResult / 10;
            sumResult = sumResult % 10;
            if (count == 1) {
                tempNodeForIteration = new Node(sumResult);
                initialHead = tempNodeForIteration;
            }
            else {
                Node tempSumNode = new Node(sumResult);
                tempNodeForIteration.next = tempSumNode;
                tempNodeForIteration = tempNodeForIteration.next;
            }

        }
        if (carryVal != 0) {
            Node tempNode = new Node(carryVal);
            tempNodeForIteration.next = tempNode;
        }
        return initialHead;
    }


    /**
     * @param firstString
     *            secondString
     *            takes the value of the numbers to be added
     *            as string
     * @return string output from the output result function
     */
    public static String main(String firstString, String secondString) {

        AddLinkedList list = new AddLinkedList();

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

        firstNum = reverse(firstNum);

        secondNum = reverse(secondNum);

        Node result = list.addLinkedLists(firstNum, secondNum);

        result = reverse(result);

        return list.outputResult(result);

    }

}
