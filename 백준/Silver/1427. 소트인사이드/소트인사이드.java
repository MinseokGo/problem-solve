import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] chars = br.readLine().toCharArray();
		
		Arrays.sort(chars);

		String str = new String(chars);
		StringBuilder sb = new StringBuilder(str).reverse();
		
		System.out.print(sb);
	}
}