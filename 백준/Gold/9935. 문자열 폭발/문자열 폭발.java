import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();

        String input = br.readLine();
        final String bomb = br.readLine();

        for (int i = 0; i < input.length(); i++) {
            final char ch = input.charAt(i);
            stack.push(ch);

            if (stack.size() >= bomb.length()) {
                boolean isPrime = true;
                for (int j = 0; j < bomb.length(); j++) {
                    if (stack.get(stack.size() - bomb.length() + j) != bomb.charAt(j)) {
                        isPrime = false;
                        break;
                    }
                }

                if (isPrime) {
                    for (int j = 0; j < bomb.length(); j++) {
                        stack.pop();
                    }
                }
            }
        }

        StringBuilder result = new StringBuilder();
        if (stack.isEmpty()) {
            result.append("FRULA");
        }
        if (!stack.isEmpty()) {
            for (char ch : stack) {
                result.append(ch);
            }
        }

        System.out.println(result);
    }
}