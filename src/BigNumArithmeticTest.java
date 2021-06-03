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
    public void simpleTwoAddition() throws IOException {
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
    public void simpleThreeAddition() throws IOException {
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
    public void complexThreeAddition() throws IOException {
        final ByteArrayOutputStream outputStreamCaptor =
            new ByteArrayOutputStream();
        
        System.setOut(new PrintStream(outputStreamCaptor));
        FileWriter myWriter = new FileWriter("test-file.txt");
        myWriter.write("1999999999 2999999997 + 1 +");
        myWriter.close();
        bigNum.main(new String[]{"test-file.txt"});
        assertEquals("1999999999 2999999997 + 1 + = "
            + "4999999997", outputStreamCaptor.toString().trim());
    }
    
    /**
     * @throws IOException 
     * returns true if the condition passes
     * checks for big numbers
     */
    @Test
    public void simpleTwoMultiplication() throws IOException {
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
    public void simpleThreeMultiplication() throws IOException {
        final ByteArrayOutputStream outputStreamCaptor =
            new ByteArrayOutputStream();
        
        System.setOut(new PrintStream(outputStreamCaptor));
        FileWriter myWriter = new FileWriter("test-file.txt");
        myWriter.write("3 5 * 5 *");
        myWriter.close();
        bigNum.main(new String[]{"test-file.txt"});
        assertEquals("3 5 * 5 * = 75", outputStreamCaptor.toString().trim());
    }
 
    /**
     * @throws IOException 
     * returns true if the condition passes
     * checks for big numbers
     */
    @Test
    public void simpleExponentiation() throws IOException {
        final ByteArrayOutputStream outputStreamCaptor =
            new ByteArrayOutputStream();
        
        System.setOut(new PrintStream(outputStreamCaptor));
        FileWriter myWriter = new FileWriter("test-file.txt");
        myWriter.write("5 3 ^");
        myWriter.close();
        bigNum.main(new String[]{"test-file.txt"});
        assertEquals("5 3 ^ = 125", outputStreamCaptor.toString().trim());
    }
    
    /**
     * @throws IOException 
     * returns true if the condition passes
     * checks for big numbers
     */
    @Test
    public void simpleRPN() throws IOException {
        final ByteArrayOutputStream outputStreamCaptor =
            new ByteArrayOutputStream();
        
        System.setOut(new PrintStream(outputStreamCaptor));
        FileWriter myWriter = new FileWriter("test-file.txt");
        myWriter.write("3 5 * 5 +");
        myWriter.close();
        bigNum.main(new String[]{"test-file.txt"});
        assertEquals("3 5 * 5 + = 20", outputStreamCaptor.toString().trim());
    }
    
    /**
     * @throws IOException 
     * returns true if the condition passes
     * checks for big numbers
     */
    @Test
    public void simpleRPN2() throws IOException {
        final ByteArrayOutputStream outputStreamCaptor =
            new ByteArrayOutputStream();
        
        System.setOut(new PrintStream(outputStreamCaptor));
        FileWriter myWriter = new FileWriter("test-file.txt");
        myWriter.write("3 5 * 5 + 2 ^");
        myWriter.close();
        bigNum.main(new String[]{"test-file.txt"});
        assertEquals("3 5 * 5 + 2 ^ = 400", 
            outputStreamCaptor.toString().trim());
    }

}
