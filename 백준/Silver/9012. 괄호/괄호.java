import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		final int testCase = Integer.parseInt(br.readLine());
		
			for (int i = 0; i < testCase; i++) {
				final String inputString = br.readLine();
				boolean isPrime = true;
				Stack<Character> stack = new Stack<>();
				
				for (int j = 0; j < inputString.length(); j++) {
					final char ch = inputString.charAt(j);
					if (ch == '(') {
						stack.add(ch);
					}
					if (ch == ')') {
						if (stack.isEmpty()) {
							sb.append("NO")
								.append("\n");
							isPrime = false;
							break;
						}
						stack.pop();
					}
				}
				if (isPrime) {
					if (stack.isEmpty()) {
						sb.append("YES")
						.append("\n");
					}
					if (!stack.isEmpty()) {
						sb.append("NO")
						.append("\n");
					}
				}
			}
		
		System.out.print(sb);
	}
}