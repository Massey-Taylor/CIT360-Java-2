package defaultpackage;

public class JunitTesting {
	
	public int multiply(int x, int y){
		return x*y;
	}
	
	public int numberOfT(String words){
		int count = 0;
		for(int i = 0; i < words.length(); i++){
			if(words.charAt(i)=='t' || words.charAt(i)=='T'){
				count++;
			}
		}
		return count;
	}
}
