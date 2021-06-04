import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * This BigNumArithmetic class implements a “BigNumArithmetic” or infinite
 * precision arithmetic package for non-negative integers.
 * 
 * @author maneeshavenigalla maneesha24@vt.edu
 * @version 1.0
 *
 */
public class BigNumArithmetic {
    /**
     * @param args an array of command-line
     * arguments for the application
     * takes the input file (sampleInputFile.txt) as
     *  an argument
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader scannedFile = openFile(args[0]);
        String line;
        while ((line = scannedFile.readLine()) != null) {
            if (line.length() > 2) 
            {
                String parsedLine = lineParser(line);
                String rpnOutput = rpnCalc(parsedLine);
                printOutput(parsedLine, rpnOutput);
            }
        }
    }


    /**
     * @param filename name of the input file
     * opens the file and reads its contents
     * @return scanned file
     * @throws FileNotFoundException
     */
    public static BufferedReader openFile(String filename)
        throws FileNotFoundException {
        FileReader file = new FileReader(filename);
        return new BufferedReader(file);
    }


    /**
     * removes leading zeroes
     * @param line value
     * takes string line as input
     * @return processed string
     */
    public static String removeLeadingZeroes(String line) {
        String regex = "^0+(?!$)";
        return line.replaceAll(regex, "");
    }


    /**
     * parses the line by removing leading zeroes and spaces
     * @param line line to be parsed
     * takes string line as input
     * @return processed line
     */
    public static String lineParser(String line) {
        String processedLine = line.trim().replaceAll("\\s+", " ");
        return processedLine;
    }


    /**
     * @param line takes individual line of the file as arg
     * takes the array of the
     * string from each line of file
     * @return the output of rpn expression
     */
    public static String rpnCalc(String line) {
        DefinedStack definedStack = new DefinedStack();

        String[] data = line.split(" ");
        for (String val : data) {
            val = removeLeadingZeroes(val);
            if (checkOperator(val)) {
                if (val.equals("+")) 
                {
                    String sumNum1 = definedStack.pop();
                    String sumNum2 = definedStack.pop();
                    AddLinkedList addList = new AddLinkedList();
                    String sumOutput = addList.main(sumNum1, sumNum2);
                    definedStack.push(sumOutput);
                }
                else if (val.equals("*")) 
                {
                    String prodNum1 = definedStack.pop();
                    String prodNum2 = definedStack.pop();
                    MulLinkedList mulList = new MulLinkedList();
                    String mulOutput = mulList.main(prodNum1, prodNum2);
                    definedStack.push(removeLeadingZeroes(mulOutput));
                }
                else
                {
                    if (definedStack.getStackSize() >= 2) 
                    {
                        String expNum1 = definedStack.pop();
                        String expNum2 = definedStack.pop();
                        ExpLinkedList expList = new ExpLinkedList();
                        String expOutput = expList.main(expNum1, expNum2);
                        definedStack.push(removeLeadingZeroes(expOutput));
                    }
                    else 
                    {
                        return "";
                    }
                }
            }
            else 
            {
                definedStack.push(val);
            }
        }

        return definedStack.getStackSize() == 1 ? definedStack.pop() : "";
    }


    /**
     * @param val operator
     * checks if the value is an operator
     */
    private static boolean checkOperator(String val) {
        return (val.equals("+") || val.equals("*") || val.equals("^"));
    }


    /**
     * @param line input line
     * @param value
     * result of the expression
     * prints the result on screen
     */
    public static void printOutput(String line, String value) {
        System.out.println(line + " = " + value);
    }
}
