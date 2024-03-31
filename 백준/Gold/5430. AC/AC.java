import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        final int times = Integer.parseInt(br.readLine());

        for (int i = 0; i < times; i++) {
            final String functions = br.readLine();
            final int size = Integer.parseInt(br.readLine());
            String input = br.readLine();
            boolean isReverse = false;
            boolean isCorrect = true;

            List<Integer> numbers = parse(input);
            for (int j = 0; j < functions.length(); j++) {
                final char function = functions.charAt(j);
                if (function == 'R') {
                    isReverse = !isReverse;
                }
                if (function == 'D') {
                    if (numbers.isEmpty()) {
                        sb.append("error")
                                .append("\n");
                        isCorrect = false;
                        break;
                    }
                    if (isReverse) {
                        numbers.remove(numbers.size() - 1);
                    }
                    if (!isReverse) {
                        numbers.remove(0);
                    }
                }
            }
            if (isCorrect) {
                sb.append("[");
                if (isReverse) {
                    for (int j = numbers.size() - 1; j >= 0; j--) {
                        sb.append(numbers.get(j));
                        if (j != 0) {
                            sb.append(",");
                        }
                    }
                }
                if (!isReverse) {
                    for (int j = 0; j < numbers.size(); j++) {
                        sb.append(numbers.get(j));
                        if (j != numbers.size() - 1) {
                            sb.append(",");
                        }
                    }
                }
                sb.append("]")
                        .append("\n");
            }
        }
        System.out.println(sb);
    }

    static List<Integer> parse(String input) {
        input = input.substring(1, input.length() - 1);
        StringTokenizer tokens = new StringTokenizer(input, "\\,");
        List<Integer> numbers = new ArrayList<>();
        while (tokens.hasMoreTokens()) {
            final int number = Integer.parseInt(tokens.nextToken());
            numbers.add(number);
        }
        return numbers;
    }
}