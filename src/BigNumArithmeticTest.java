import static org.junit.Assert.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import org.junit.Test;

/**
 * This BigNumArithmetic class tests the a “BigNumArithmetic” class or infinite
 * precision arithmetic package for non-negative integers.
 * @author maneeshavenigalla maneesha24@vt.edu
 * @version 1.0
 *
 */
public class BigNumArithmeticTest {

    private BigNumArithmetic bigNum;

    /**
     * @throws IOException 
     * returns true if the condition passes
     * checks for two numbers
     */
    @Test
    public void testFileFunc() throws IOException {
        final PrintStream standardOut = System.out;
        final ByteArrayOutputStream outputStreamCaptor =
            new ByteArrayOutputStream();
        
        System.setOut(new PrintStream(outputStreamCaptor));
        FileWriter myWriter = new FileWriter("test-file.txt");
        myWriter.write("3 5 +");
        myWriter.close();
        bigNum.main(new String[]{"test-file.txt"});
        assertEquals("3 5 + = 8", outputStreamCaptor.toString().trim());
    }
    
    /**
     * @throws IOException 
     * returns true if the condition passes
     * checks for three numbers
     */
    @Test
    public void testFileFunc2() throws IOException {
        final PrintStream standardOut = System.out;
        final ByteArrayOutputStream outputStreamCaptor =
            new ByteArrayOutputStream();
        
        System.setOut(new PrintStream(outputStreamCaptor));
        FileWriter myWriter = new FileWriter("test-file.txt");
        myWriter.write("3 5 + 8 +");
        myWriter.close();
        bigNum.main(new String[]{"test-file.txt"});
        assertEquals("3 5 + 8 + = 16", outputStreamCaptor.toString().trim());
    }
    
    /**
     * @throws IOException 
     * returns true if the condition passes
     * checks for big numbers
     */
    @Test
    public void testFileFunc3() throws IOException {
        final PrintStream standardOut = System.out;
        final ByteArrayOutputStream outputStreamCaptor =
            new ByteArrayOutputStream();
        
        System.setOut(new PrintStream(outputStreamCaptor));
        FileWriter myWriter = new FileWriter("test-file.txt");
        myWriter.write("1999999999 2999999999 3999999999 + +");
        myWriter.close();
        bigNum.main(new String[]{"test-file.txt"});
        assertEquals("1999999999 2999999999 3999999999 + + = 8999999997", outputStreamCaptor.toString().trim());
    }
    
    /**
     * @throws IOException 
     * returns true if the condition passes
     * checks for big numbers
     */
    @Test
    public void testFileFunc4() throws IOException {
        final PrintStream standardOut = System.out;
        final ByteArrayOutputStream outputStreamCaptor =
            new ByteArrayOutputStream();
        
        System.setOut(new PrintStream(outputStreamCaptor));
        FileWriter myWriter = new FileWriter("test-file.txt");
        myWriter.write("3 5 *");
        myWriter.close();
        bigNum.main(new String[]{"test-file.txt"});
        assertEquals("3 5 * = 15", outputStreamCaptor.toString().trim());
    }
    
    /**
     * @throws IOException 
     * returns true if the condition passes
     * checks for big numbers
     */
    @Test
    public void testFileFunc5() throws IOException {
        final PrintStream standardOut = System.out;
        final ByteArrayOutputStream outputStreamCaptor =
            new ByteArrayOutputStream();
        
        System.setOut(new PrintStream(outputStreamCaptor));
        FileWriter myWriter = new FileWriter("test-file.txt");
        myWriter.write("3 5 * 5 +");
        myWriter.close();
        bigNum.main(new String[]{"test-file.txt"});
        assertEquals("3 5 * 5 + = 20", outputStreamCaptor.toString().trim());
    }

}
