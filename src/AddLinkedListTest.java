import static org.junit.Assert.*;
import org.junit.Test;

public class AddLinkedListTest {
    
    AddLinkedList list;

    @Test
    public void testSimpleAddition() {
        String expectedResult = "8";
        String result = list.main("3", "5");
        assertEquals(expectedResult, result);
    }
    
    @Test
    public void testComplexAddition() {
        String expectedResult = "3999999998";
        String result = list.main("1999999999", "1999999999");
        assertEquals(expectedResult, result);
    }

}
