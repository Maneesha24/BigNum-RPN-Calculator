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
     * checks for test file
     */
    @Test
    public void testFileTest() throws IOException {
        final ByteArrayOutputStream outputStreamCaptor =
            new ByteArrayOutputStream();
        
        System.setOut(new PrintStream(outputStreamCaptor));
        bigNum.main(new String[]{"SampleInput.txt"});
        assertNotNull(outputStreamCaptor.toString().trim());

    }
    
    /**
     * @throws IOException 
     * returns true if the condition passes
     * checks for invalid rpn equation
     */
    @Test
    public void invalidRPNTest() throws IOException {
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
    
    /**
     * @throws IOException 
     * returns true if the condition passes
     * checks for simple addition
     */
    @Test
    public void simpleTwoAdditionTest() throws IOException {
        final ByteArrayOutputStream outputStreamCaptor =
            new ByteArrayOutputStream();
        
        System.setOut(new PrintStream(outputStreamCaptor));
        FileWriter myWriter = new FileWriter("test-file.txt");
        myWriter.write("2 8 +");
        myWriter.close();
        bigNum.main(new String[]{"test-file.txt"});
        assertEquals("2 8 + = 10", 
            outputStreamCaptor.toString().trim());
    }
    
    /**
     * @throws IOException 
     * returns true if the condition passes
     * checks for complex three number addition
     */
    @Test
    public void complexThreeAdditionTest() throws IOException {
        final ByteArrayOutputStream outputStreamCaptor =
            new ByteArrayOutputStream();
        
        System.setOut(new PrintStream(outputStreamCaptor));
        FileWriter myWriter = new FileWriter("test-file.txt");
        myWriter.write("1999999999 29999999999 + 39999999999 +");
        myWriter.close();
        bigNum.main(new String[]{"test-file.txt"});
        assertEquals("1999999999 29999999999 + 39999999999 + = 71999999997", 
            outputStreamCaptor.toString().trim());
    }
    
    /**
     * @throws IOException 
     * returns true if the condition passes
     * checks for simple mul of two numbers
     */
    @Test
    public void simpleTwoMultiplicationTest() throws IOException {
        final ByteArrayOutputStream outputStreamCaptor =
            new ByteArrayOutputStream();
        
        System.setOut(new PrintStream(outputStreamCaptor));
        FileWriter myWriter = new FileWriter("test-file.txt");
        myWriter.write("3 4 *");
        myWriter.close();
        bigNum.main(new String[]{"test-file.txt"});
        assertEquals("3 4 * = 12", 
            outputStreamCaptor.toString().trim());
    }
    
    /**
     * @throws IOException 
     * returns true if the condition passes
     * checks for complex three number mul
     */
    @Test
    public void complexThreeMultiplicationTest() throws IOException {
        final ByteArrayOutputStream outputStreamCaptor =
            new ByteArrayOutputStream();
        
        System.setOut(new PrintStream(outputStreamCaptor));
        FileWriter myWriter = new FileWriter("test-file.txt");
        myWriter.write("3 4 * 12 *");
        myWriter.close();
        bigNum.main(new String[]{"test-file.txt"});
        assertEquals("3 4 * 12 * = 144", 
            outputStreamCaptor.toString().trim());
    }
    
    
    /**
     * @throws IOException 
     * returns true if the condition passes
     * checks for simple exponentiation
     */
    @Test
    public void simpleExponentTest() throws IOException {
        final ByteArrayOutputStream outputStreamCaptor =
            new ByteArrayOutputStream();
        
        System.setOut(new PrintStream(outputStreamCaptor));
        FileWriter myWriter = new FileWriter("test-file.txt");
        myWriter.write("2 8 ^");
        myWriter.close();
        bigNum.main(new String[]{"test-file.txt"});
        assertEquals("2 8 ^ = 256", 
            outputStreamCaptor.toString().trim());
    }
    
    
    /**
     * @throws IOException 
     * returns true if the condition passes
     * checks for series of complex exponentiation
     */
    @Test
    public void complexExponentTest() throws IOException {
        final ByteArrayOutputStream outputStreamCaptor =
            new ByteArrayOutputStream();
        
        System.setOut(new PrintStream(outputStreamCaptor));
        FileWriter myWriter = new FileWriter("test-file.txt");
        myWriter.write("1000000 3 ^");
        myWriter.close();
        bigNum.main(new String[]{"test-file.txt"});
        assertEquals("1000000 3 ^ = 1000000000000000000", 
            outputStreamCaptor.toString().trim());
    }
    
    /**
     * @throws IOException 
     * returns true if the condition passes
     * checks for three number complex exponentiation
     */
    @Test
    public void complexThreeNumExponentTest() throws IOException {
        final ByteArrayOutputStream outputStreamCaptor =
            new ByteArrayOutputStream();
        
        System.setOut(new PrintStream(outputStreamCaptor));
        FileWriter myWriter = new FileWriter("test-file.txt");
        myWriter.write("1000000 3 ^ 2 * 1 ^");
        myWriter.close();
        bigNum.main(new String[]{"test-file.txt"});
        assertEquals("1000000 3 ^ 2 * 1 ^ = "
            + "2000000000000000000", 
            outputStreamCaptor.toString().trim());
    }
    
    /**
     * @throws IOException 
     * returns true if the condition passes
     * checks for rpn equation
     */
    @Test
    public void complexThreeNumExponentTest2() throws IOException {
        final ByteArrayOutputStream outputStreamCaptor =
            new ByteArrayOutputStream();
        
        System.setOut(new PrintStream(outputStreamCaptor));
        FileWriter myWriter = new FileWriter("test-file.txt");
        myWriter.write("5 10 ^ 2 * 1 ^");
        myWriter.close();
        bigNum.main(new String[]{"test-file.txt"});
        assertEquals("5 10 ^ 2 * 1 ^ = "
            + "19531250", 
            outputStreamCaptor.toString().trim());
    }
    
    /**
     * @throws IOException 
     * returns true if the condition passes
     * checks for unparsed rpn equation
     */
    @Test
    public void parsedMultipplication() throws IOException {
        final ByteArrayOutputStream outputStreamCaptor =
            new ByteArrayOutputStream();
        
        System.setOut(new PrintStream(outputStreamCaptor));
        FileWriter myWriter = new FileWriter("test-file.txt");
        myWriter.write("9 1 +     5 *     00000000 +");
        myWriter.close();
        bigNum.main(new String[]{"test-file.txt"});
        assertEquals("9 1 + 5 * 00000000 + = 50", 
            outputStreamCaptor.toString().trim());
    }
    
    /**
     * @throws IOException 
     * returns true if the condition passes
     * checks for rpn equation 1
     */
    @Test
    public void rpnEquationTest1() throws IOException {
        final ByteArrayOutputStream outputStreamCaptor =
            new ByteArrayOutputStream();
        
        System.setOut(new PrintStream(outputStreamCaptor));
        FileWriter myWriter = new FileWriter("test-file.txt");
        myWriter.write("000000056669777 99999911111 + "
            + "352324012 + 03 ^ 555557778 *");
        myWriter.close();
        bigNum.main(new String[]{"test-file.txt"});
        assertEquals("000000056669777 99999911111 + "
            + "352324012 + 03 ^ 555557778 * = "
            + "562400792227677956625810678708149922000000", 
            outputStreamCaptor.toString().trim());
    }
    
    /**
     * @throws IOException 
     * returns true if the condition passes
     * checks for rpn equation 2
     */
    @Test
    public void rpnEquationTest2() throws IOException {
        final ByteArrayOutputStream outputStreamCaptor =
            new ByteArrayOutputStream();
        
        System.setOut(new PrintStream(outputStreamCaptor));
        FileWriter myWriter = new FileWriter("test-file.txt");
        myWriter.write("99999999 990001 * 01119111 55565 33333 "
            + "+ * + 88888888 +");
        myWriter.close();
        bigNum.main(new String[]{"test-file.txt"});
        assertEquals("99999999 990001 * 01119111 55565 33333 "
            + "+ * + 88888888 + = "
            + "99099674628565", 
            outputStreamCaptor.toString().trim());
    }
    
    /**
     * @throws IOException 
     * returns true if the condition passes
     * checks for rpn equation 3
     */
    @Test
    public void rpnEquationTest3() throws IOException {
        final ByteArrayOutputStream outputStreamCaptor =
            new ByteArrayOutputStream();
        
        System.setOut(new PrintStream(outputStreamCaptor));
        FileWriter myWriter = new FileWriter("test-file.txt");
        myWriter.write("9 1 + 5 * 00000000 +");
        myWriter.close();
        bigNum.main(new String[]{"test-file.txt"});
        assertEquals("9 1 + 5 * 00000000 + = "
            + "50", 
            outputStreamCaptor.toString().trim());
    }
    
    /**
     * @throws IOException 
     * returns true if the condition passes
     * checks for rpn equation 4
     */
    @Test
    public void rpnEquationTest4() throws IOException {
        final ByteArrayOutputStream outputStreamCaptor =
            new ByteArrayOutputStream();
        
        System.setOut(new PrintStream(outputStreamCaptor));
        FileWriter myWriter = new FileWriter("test-file.txt");
        myWriter.write("999999999 0 *");
        myWriter.close();
        bigNum.main(new String[]{"test-file.txt"});
        assertEquals("999999999 0 * = "
            + "0", 
            outputStreamCaptor.toString().trim());
    }
    
    /**
     * @throws IOException 
     * returns true if the condition passes
     * checks for rpn equation 5
     */
    @Test
    public void rpnEquationTest5() throws IOException {
        final ByteArrayOutputStream outputStreamCaptor =
            new ByteArrayOutputStream();
        
        System.setOut(new PrintStream(outputStreamCaptor));
        FileWriter myWriter = new FileWriter("test-file.txt");
        myWriter.write("9 0 ^");
        myWriter.close();
        bigNum.main(new String[]{"test-file.txt"});
        assertEquals("9 0 ^ = "
            + "1", 
            outputStreamCaptor.toString().trim());
    }
    
    /**
     * @throws IOException 
     * returns true if the condition passes
     * checks for rpn equation 6
     */
    @Test
    public void rpnEquationTest6() throws IOException {
        final ByteArrayOutputStream outputStreamCaptor =
            new ByteArrayOutputStream();
        
        System.setOut(new PrintStream(outputStreamCaptor));
        FileWriter myWriter = new FileWriter("test-file.txt");
        myWriter.write("5555555 333333 5454353 999999 666666 01 ^ * * +");
        myWriter.close();
        bigNum.main(new String[]{"test-file.txt"});
        assertEquals("5555555 333333 5454353 999999 666666 01 ^ * * + =", 
            outputStreamCaptor.toString().trim());
    }
    
    /**
     * @throws IOException 
     * returns true if the condition passes
     * checks for rpn equation 7
     */
    @Test
    public void rpnEquationTest7() throws IOException {
        final ByteArrayOutputStream outputStreamCaptor =
            new ByteArrayOutputStream();
        
        System.setOut(new PrintStream(outputStreamCaptor));
        FileWriter myWriter = new FileWriter("test-file.txt");
        myWriter.write("3432 3333 9999 + * ^ * * 6666 +");
        myWriter.close();
        bigNum.main(new String[]{"test-file.txt"});
        assertEquals("3432 3333 9999 + * ^ * * 6666 + =", 
            outputStreamCaptor.toString().trim());
    }
    
    /**
     * @throws IOException 
     * returns true if the condition passes
     * checks for large exponent power
     */
    @Test
    public void rpnEquationTest8() throws IOException {
        final ByteArrayOutputStream outputStreamCaptor =
            new ByteArrayOutputStream();
        
        System.setOut(new PrintStream(outputStreamCaptor));
        FileWriter myWriter = new FileWriter("test-file.txt");
        myWriter.write("123456 123 ^");
        myWriter.close();
        bigNum.main(new String[]{"test-file.txt"});
        assertEquals("123456 123 ^ = 18030210630404480750814092"
            + "7865938572807342688638559680488440159857958502360"
            + "81373250219782696986322573087163043641979475893207"
            + "43503803676976498146265429266026647072758742692017"
            + "777439123131975163236902212747138458954577487353094"
            + "843371913732555279282717852063829679989843304821053"
            + "509422299706770549408382109369523039394016567561276"
            + "077785996672437028140727462194319422930054164116350"
            + "7602129604549330513364561556659073596565258793429042"
            + "5473827719935012870093575987789431818047013404691795"
            + "7731704057646146460549492988461846782968136255953333"
            + "1161138525173524450544844305005054716177922974913448"
            + "9643622579100908331839817426366854332416", 
            outputStreamCaptor.toString().trim());
    }
    
    


}
