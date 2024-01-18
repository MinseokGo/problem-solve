import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        final int times = Integer.parseInt(br.readLine());

        for (int i = 0; i < times; i++) {
            final int size = Integer.parseInt(br.readLine());
            String[] numbers = new String[size];
            for (int j = 0; j < size; j++) {
                final String number = br.readLine();
                numbers[j] = number;
            }

            Arrays.sort(numbers);
            boolean isPrime = true;
            for (int j = 0; j < numbers.length - 1; j++) {
                if (numbers[j].startsWith(numbers[j+1])) {
                    isPrime = false;
                    sb.append("NO")
                            .append("\n");
                    break;
                }
                if (numbers[j+1].startsWith(numbers[j])) {
                    isPrime = false;
                    sb.append("NO")
                            .append("\n");
                    break;
                }
            }

            if (isPrime) {
                sb.append("YES")
                        .append("\n");
            }
        }

        System.out.print(sb);
    }
}
