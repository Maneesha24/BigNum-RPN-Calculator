import java.util.Stack;

public class AddNum {
	
	static ListNode firstNum, secondNum, result;
	
	public static void firstNumVal(int data) {
		ListNode newNode = new ListNode(0);
		newNode.data = data;
		newNode.next = firstNum;
	 	firstNum = newNode;
	}
	
	public static void secondNumVal(int data) {
		ListNode newNode = new ListNode(0);
		newNode.data = data;
		newNode.next = secondNum;
		secondNum = newNode;
	}
	
	// Add two numbers
	public static ListNode addNum() {
		
		Stack<Integer> stack1 = new Stack<>();
	    Stack<Integer> stack2 = new Stack<>();
	 
	    while (firstNum != null)
	    {
	        stack1.add(firstNum.data);
	        firstNum = firstNum.next;
	    }
	 
	    while (secondNum != null)
	    {
	        stack2.add(secondNum.data);
	        secondNum = secondNum.next;
	    }
	    
	    int carry = 0;
	    ListNode result = null;
	 
	    while (!stack1.isEmpty() ||
	           !stack2.isEmpty())
	    {
	        int a = 0, b = 0;
	 
	        if (!stack1.isEmpty())
	        {
	            a = stack1.pop();
	        }
	 
	        if (!stack2.isEmpty())
	        {
	            b = stack2.pop();
	        }
	 
	        int total = a + b + carry;
	 
	        ListNode temp = new ListNode(total % 10);
	        carry = total / 10;
	 
	        if (result == null)
	        {
	            result = temp;
	        }
	        else
	        {
	            temp.next = result;
	            result = temp;
	        }
	    }
	 
	    if (carry != 0)
	    {
	    	ListNode temp = new ListNode(carry);
	        temp.next = result;
	        result = temp;
	    }
	    return result;
		
	}
	
	public static ListNode main(String firstNum, String secondNum) {
		
		String[] firstData1 = firstNum.split("");
		String[] secondData1 = secondNum.split("");

		
		for(String val: firstData1) {
			firstNumVal(Integer.parseInt(val));
		}
		
		for(String val: secondData1) {
			secondNumVal(Integer.parseInt(val));
		}
		
	    return addNum();
	}
}

class ListNode {
	int data;
    ListNode next;
     
    public ListNode(int data) {
        this.data = data;
    }
    
    public int getValue() {
        return data;
    }
}
