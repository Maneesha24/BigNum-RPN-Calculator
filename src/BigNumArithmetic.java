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
	 * @param args takes the input file (sampleInputFile.txt) as an argument
	 * @throws IOException
	 */
	public static void main(String args[]) throws IOException {
		BufferedReader scannedFile = openFile("SampleInput.txt");
		int i = 0;
		String line;
		while((line = scannedFile.readLine()) != null) {
			if(line.length() > 2) {
				String parsedLine = lineParser(line);
				String rpnOutput = rpnCalc(parsedLine);
				printOutput(parsedLine, rpnOutput);
			}
		}
	}

	/**
	 * opens the file and reads its contents
	 * 
	 * @param fileName name of the file to be read
	 * @return scanned file
	 * @throws FileNotFoundException
	 */
	public static BufferedReader openFile(String filename) throws FileNotFoundException {
		FileReader file =  new FileReader(filename);
		return new BufferedReader(file);
	}

	/**
	 * parses the line by removing leading zeroes and spaces
	 * 
	 * @param line takes string line as input
	 * @return processed line
	 */
	public static String lineParser(String line) {
		String processedLine = line.trim().replaceAll("\\s+", " ");
		return processedLine.replaceAll("^0+(?!$)", "");

	}

	/**
	 * @param line takes individual line of the file as arg takes the array of the
	 *             string from each line of file
	 */
	public static String rpnCalc(String line) {
		DefinedStack definedStack = new DefinedStack();

		String[] data = line.split(" ");
		for (String val : data) {
			switch (val) {
			case "+":
				String sumNum1 = definedStack.pop();
				String sumNum2 = definedStack.pop();
				int output = AddNum.main(sumNum1, sumNum2).getValue();
				definedStack.push(Integer.toString(output));
				break;
			case "*":
//				String prodNum1 = definedStack.pop();
//				String prodNum2 = definedStack.pop();
//				definedStack.push(prodNum1.multiply(prodNum2));
				break;
			case "^":
//				String expNum1 = definedStack.pop();
//				String expNum2 = definedStack.pop();
//				definedStack.push(expNum1.multiply(expNum2));
				break;
			default:
				definedStack.push(val);
				break;
			}
		}
		return definedStack.pop();
	}

	/**
	 * @param line value takes line and result of RPN as input outputs the print
	 *             statement
	 */
	public static void printOutput(String line, String value) {
		System.out.println(line + " = " + value);
	}
}
