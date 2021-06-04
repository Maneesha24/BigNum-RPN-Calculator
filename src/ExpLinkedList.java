/**
 * This MulLinkedList class implements a “MulLinkedList”
 * which multiplies two linked lists and outputs a result
 * 
 * @author maneeshavenigalla maneesha24@vt.edu
 * @version 1.0
 *
 */
public class ExpLinkedList {

    private static Node head;

    /**
     * This Node class implements a “Node”
     * which represents indv node in the list
     * @author maneeshavenigalla maneesha24@vt.edu
     * @version 1.0
     */
    private static class Node {
        private int value = 0;
        private Node next = null;

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
        if (node.next == null) {
            return node;
        }

        Node nextNodes = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return nextNodes;
    }
    
    /**
     * @param firstNode first head
     * @param val individual value to be mul
     * @return initialHead
     */
    public static Node multiplyTwoDigit(Node firstNode, int val) {
        
        Node lastNumNode = new Node(-1);
        Node currentAns = lastNumNode;
        Node currentNode = firstNode;
        int carryVal = 0;
        
        while (currentNode != null || carryVal != 0) {
            int sum = carryVal + (currentNode != null 
                ? currentNode.value : 0) * val;
            
            int indv = sum % 10;
            carryVal = sum / 10;
            
            currentAns.next = new Node(indv);
            
            if (currentNode != null) 
            {
                currentNode = currentNode.next;
            }
            currentAns = currentAns.next;
        }
        
        return lastNumNode.next;
    }


    /**
     * @param firstStr firstNumber
     * @param secondStr secondnumber
     * takes the value of the numbers to be added
     * @return initialHead
     * returns the addition of two linked lists
     */
    public static String mulLinkedLists(String firstStr, String secondStr) {
        
        ExpLinkedList list = new ExpLinkedList();
        
        Node firstNum = new Node(Character.getNumericValue(firstStr.charAt(
            0)));
        list.appendAtTheEnd(firstNum);

        for (int i = 1; i < firstStr.length(); i++) {
            list.appendAtTheEnd(new Node(Character.getNumericValue(firstStr
                .charAt(i))));
        }

        head = null;
        Node secondNum = new Node(Character.getNumericValue(secondStr.charAt(
            0)));
        list.appendAtTheEnd(secondNum);
        for (int j = 1; j < secondStr.length(); j++) {
            list.appendAtTheEnd(new Node(Character.getNumericValue(secondStr
                .charAt(j))));
        }

        firstNum = reverse(firstNum);

        secondNum = reverse(secondNum);
        
        Node secondNumItr = secondNum;
        
        Node lastNum = new Node(-1);
        
        Node resItr = lastNum;
        
        while (secondNumItr != null) {
            Node prod = multiplyTwoDigit(firstNum, secondNumItr.value);
            secondNumItr = secondNumItr.next;
            
            addTwoLists(prod, resItr);
            
            resItr = resItr.next;
        }
        return getOutput(reverse(lastNum.next));
    }

    /**
     * @param firstNum firstnumber node
     * @param resItr result iterator
     * takes the value of the strings to be added
     *  as string
     */
    private static void addTwoLists(Node firstNum, Node resItr) {
        
        Node currentNode = firstNum;
        Node resultNode = resItr;
        int carryVal = 0;
        
        while (currentNode != null || carryVal != 0) {
            int sum = carryVal + (currentNode != null ? currentNode.value : 0)
                + (resultNode.next != null ? resultNode.next.value : 0);
            
            int value = sum % 10;
            
            carryVal = sum / 10;
            
            if (resultNode.next != null) 
            {
                resultNode.next.value = value;
            } 
            else 
            {
                resultNode.next = new Node(value);
            }
            
            if (currentNode != null) 
            {
                currentNode = currentNode.next;
            }
            resultNode = resultNode.next;
        }
    }


    /**
     * @param firstString firstnum
     * @param secondString secondnum
     * takes the value of the strings to be added
     *  as string
     * @return string output from the output result function
     */
    public static String main(String firstString, String secondString) {

        String expProd = expLinkedLists(firstString, secondString);
                
        return expProd;
    }
    
    /**
     * @param firstString firstNumber
     * @param secondString secondnumber
     * takes the value of the numbers to be be powered
     * @return result
     * returns the power exp of two linked lists
     */
    private static String expLinkedLists(String 
        firstString, String secondString) {
        
        int power = Integer.parseInt(firstString);
        
        String square = mulLinkedLists(secondString, secondString);
        String tempString = square;
        
        if (power == 0) 
        {
            return "1";  
        }
        else if (power == 1)
        {
            return secondString;
        }
                
        if (power % 2 == 0) 
        {
            //If power is even  
            //Formula from canvas - (x ^ 2) ^ (n/2)
            int n = power / 2;
            for (int i = 1; i < n; i++) {
                tempString = mulLinkedLists(tempString, square);
            }
        } 
        else
        {
             // If power is odd
             // Formula from canvas - x * (x ^ 2) ^ (n - 1/2)
            int n = power;
            for (int i = 1; i < n - 1; i++) {
                String prod = mulLinkedLists(tempString, secondString);
                tempString = prod;
            }
        }
            
        return tempString;

    }

    /**
     * @param resultNode outputnode
     * takes the value of output node to be printed
     *  as string
     * @return string output from the output result function
     */
    private static String getOutput(Node resultNode) {
        String result = "";
        Node temp = resultNode;
        while (temp != null) {
            result += Integer.toString(temp.value);
            temp = temp.next;
        }

        return result;
    }

}