package defaultpackage;

import static org.junit.Assert.*;

import org.junit.Test;

public class numberOfT {

	@Test
	public void test() {
			JunitTesting test = new JunitTesting();
			int output = test.numberOfT("Taylor is the best");
			assertEquals(3, output);
		
	}

}