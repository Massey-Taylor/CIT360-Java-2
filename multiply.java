package defaultpackage;

import static org.junit.Assert.*;

import org.junit.Test;

public class multiply {

	@Test
	public void test() {
		JunitTesting test = new JunitTesting();
		int output = test.multiply(5,6);
		assertEquals(30, output);
	}

}
