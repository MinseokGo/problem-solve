import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        final int N = Integer.parseInt(br.readLine());
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        Map<Integer, Integer> numberMap = new HashMap<>();
        List<Integer> oldNumbers = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();

        while (tokenizer.hasMoreTokens()) {
            final int number = Integer.parseInt(tokenizer.nextToken());
            numbers.add(number);
            oldNumbers.add(number);
        }

        Collections.sort(numbers);

        int sequence = -1;
        for (final int number : numbers) {
            if (!numberMap.containsKey(number)) {
                numberMap.put(number, ++sequence);
            }
        }

        for (final int number : oldNumbers) {
            final int rank = numberMap.get(number);
            sb.append(rank)
                    .append(" ");
        }

        System.out.println(sb);
    }
}
