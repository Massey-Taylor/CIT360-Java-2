package defaultpackage;

import org.junit.Test;
import static org.junit.Assert.*;


public class MoreJUnitTests {
	@Test
    public void Arrays() throws Exception {
		int[] arrayOne = {2, 5, 6};
		int[] arrayTwo = {2, 5, 6};
		assertArrayEquals(arrayOne, arrayTwo);
}
	@Test
    public void NotSameName() throws Exception {
        String nameOne = new String();
        String nameTwo = new String();
        nameOne = "Taylor Massey";
        nameTwo = "Taylor Masey";
        assertNotSame(nameOne, nameTwo);
}
	@Test
    public void SameName() throws Exception {
		String firstName = new String();
        firstName = "Taylor";
        assertSame("Taylor", firstName);
}
	public boolean isEvenNumber(int num){   
        boolean result = false;
        if(num%2 == 0){
            result = true;
        }
        return result;
	}

	@Test
	public void False() throws Exception {
        boolean result = isEvenNumber(11);
        assertFalse(result);
    }
	
	@Test
    public void NotNull() throws Exception {
        String firstName = new String();
        firstName = "Taylor";
        assertNotNull(firstName);
}
	
	@Test
    public void Null() throws Exception {
        String firstName = new String();
        firstName = null;
        assertNull(firstName);
}
	
}
