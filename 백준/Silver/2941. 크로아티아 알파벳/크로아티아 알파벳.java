import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String inputString = br.readLine();
		String[] alphabets = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		int count = 0;
		
		for (int i = 0; i < alphabets.length; i++) {
			final String alphabet = alphabets[i];
			
			if (inputString.contains(alphabet)) {
				final int inputLen = inputString.replace(" ", "").length();
				final int alphabetLen = alphabet.length();
				
				inputString = inputString.replace(alphabet, " ");
				final int tempLen = inputString.replace(" ", "").length();
				
				count += (inputLen - tempLen) / alphabetLen;
			}
		}
		inputString = inputString.replace(" ", "");
		
		if (inputString.length() != 0) {
			count += inputString.length();
		}
		
		System.out.print(count);
	}
}