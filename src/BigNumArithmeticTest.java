import java.io.FileNotFoundException;
import org.junit.Test;

/**
 * This BigNumArithmetic class tests the a “BigNumArithmetic” class or infinite
 * precision arithmetic package for non-negative integers.
 * 
 * @author maneeshavenigalla maneesha24@vt.edu
 * @version 1.0
 *
 */
public class BigNumArithmeticTest {

	private BigNumArithmetic bigNum;

	@Test
	public void testFileFunc() throws FileNotFoundException {
		bigNum.openFile("SampleInput.txt");
	}

}
