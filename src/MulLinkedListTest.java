import static org.junit.Assert.*;
import org.junit.Test;

public class MulLinkedListTest {

    
    MulLinkedList list;

    @Test
    public void testSimpleMultiplication() {
        String expectedResult = "15";
        String result = list.main("3", "5");
        assertEquals(expectedResult, result);
    }
    
    @Test
    public void testComplexMultiplication() {
        String expectedResult = "130";
        String result = list.main("13", "10");
        assertEquals(expectedResult, result);
    }
}
