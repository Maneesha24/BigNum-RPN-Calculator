import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.io.ByteArrayOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import org.junit.FixMethodOrder;
import org.junit.Test;

/**
 * This BigNumArithmetic class tests the a “BigNumArithmetic” class or infinite
 * precision arithmetic package for non-negative integers.
 * @author maneeshavenigalla maneesha24@vt.edu
 * @version 1.0
 *
 */
@FixMethodOrder()
public class BigNumArithmeticTest {

    private BigNumArithmetic bigNum = new BigNumArithmetic();
    
    /**
     * @throws IOException 
     * returns true if the condition passes
     * checks for big numbers
     */
    @Test
    public void testFile() throws IOException {
        final ByteArrayOutputStream outputStreamCaptor =
            new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        bigNum.main(new String[]{"SampleInput.txt"});
        assertNotNull(outputStreamCaptor.toString().trim());

    }
    
    /**
     * @throws IOException 
     * returns true if the condition passes
     * checks for big numbers
     */
    @Test
    public void invalidRPN() throws IOException {
        final ByteArrayOutputStream outputStreamCaptor =
            new ByteArrayOutputStream();
        
        System.setOut(new PrintStream(outputStreamCaptor));
        FileWriter myWriter = new FileWriter("test-file.txt");
        myWriter.write("2 8 + 2");
        myWriter.close();
        bigNum.main(new String[]{"test-file.txt"});
        assertEquals("2 8 + 2 =", 
            outputStreamCaptor.toString().trim());
    }

}
