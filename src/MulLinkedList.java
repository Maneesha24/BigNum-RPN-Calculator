public class MulLinkedList {
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

    public static long mulLinkedLists(Node first, Node second) {
        long N = 1000000007;
        long num1 = 0, num2 = 0;

        while (first != null || second != null) {

            if (first != null) {
                num1 = ((num1) * 10) % N + first.value;
                first = first.next;
            }

            if (second != null) {
                num2 = ((num2) * 10) % N + second.value;
                second = second.next;
            }

        }
        return ((num1 % N) * (num2 % N)) % N;
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


    public static String main(String firstString, String secondString) {

        MulLinkedList list = new MulLinkedList();

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


        long result = list.mulLinkedLists(firstNum, secondNum);

        return Long.toString(result);

    }

}
