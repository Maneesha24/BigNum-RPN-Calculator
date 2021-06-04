import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

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
     * @param args
     *            an array of command-line
     *            arguments for the application
     *            takes the input file (sampleInputFile.txt) as
     *            an argument
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        Scanner scannedFile = openFile(args[0]);
        while (scannedFile.hasNextLine()) {
            String line = scannedFile.nextLine();
            if (line.length() > 2) {
                String parsedLine = lineParser(line);
                String rpnOutput = rpnCalc(parsedLine);
                printOutput(parsedLine, rpnOutput);
            }
        }
    }


    /**
     * @param filename
     *            name of the input file
     *            opens the file and reads its contents
     * @return scanned file
     * @throws FileNotFoundException
     */
    public static Scanner openFile(String filename)
        throws FileNotFoundException {
        FileReader file = new FileReader(filename);
        return new Scanner(file);
    }


    /**
     * removes leading zeroes
     * 
     * @param line
     *            value
     *            takes string line as input
     * @return processed string
     */
    public static String removeLeadingZeroes(String line) {
        String regex = "^0+(?!$)";
        return line.replaceAll(regex, "");
    }


    /**
     * parses the line by removing leading zeroes and spaces
     * 
     * @param line
     *            line to be parsed
     *            takes string line as input
     * @return processed line
     */
    public static String lineParser(String line) {
        String processedLine = line.trim().replaceAll("\\s+", " ");
        return processedLine;
    }


    /**
     * @param line
     *            takes individual line of the file as arg
     *            takes the array of the
     *            string from each line of file
     * @return the output of rpn expression
     */
    public static String rpnCalc(String line) {
        DefinedStack stack = new DefinedStack();
        stack.emptyStack();   

        String[] data = line.split(" ");
        Boolean error = false;
        for (String val : data) {
            val = removeLeadingZeroes(val);
            switch (val) {
                case "+":
                    if (stack.getStackSize() > 1) {
                        String sumNum1 = stack.pop();
                        String sumNum2 = stack.pop();
                        AddLinkedList addList = new AddLinkedList();
                        String sumOutput = addList.main(sumNum1, sumNum2);
                        stack.push(sumOutput);
                    }
                    else {
                        error = true;
                    }
                    break;
                case "*":
                    if (stack.getStackSize() > 1) {
                        String prodNum1 = stack.pop();
                        String prodNum2 = stack.pop();
                        ExpLinkedList expList = new ExpLinkedList();
                        String mulOutput = expList.
                            mulLinkedLists(prodNum1, prodNum2);
                        stack.push(removeLeadingZeroes(mulOutput));
                    }
                    else {
                        error = true;
                    }
                    break;
                case "^":
                    if (stack.getStackSize() > 1) {
                        String expNum1 = stack.pop();
                        String expNum2 = stack.pop();
                        ExpLinkedList expList = new ExpLinkedList();
                        String expOutput = expList.main(expNum1, expNum2);
                        stack.push(removeLeadingZeroes(expOutput));
                    }
                    else {
                        error = true;
                    }
                    break;
                default:
                    stack.push(val);
                    break;

            }
        }

        if (!error && stack.getStackSize() == 1) {
            return stack.pop();
        }
        stack.emptyStack();
        return "";
    }


    /**
     * @param line
     *            input line
     * @param value
     *            result of the expression
     *            prints the result on screen
     */
    public static void printOutput(String line, String value) {
        System.out.println(line + " = " + value);
    }
}
