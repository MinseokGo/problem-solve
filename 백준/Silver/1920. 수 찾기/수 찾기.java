import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        final String N = br.readLine();
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        Set<String> numbersA = new TreeSet<>();
        while (stringTokenizer.hasMoreTokens()) {
            numbersA.add(stringTokenizer.nextToken());
        }

        final String M = br.readLine();
        stringTokenizer = new StringTokenizer(br.readLine());
        List<String> numbers = new ArrayList<>();
        while (stringTokenizer.hasMoreTokens()) {
            final String number = stringTokenizer.nextToken();
            numbers.add(number);
        }

        for (String number : numbers) {
            if (numbersA.contains(number)) {
                sb.append("1")
                        .append("\n");
            }
            else {
                sb.append("0")
                        .append("\n");
            }
        }

        System.out.println(sb);
    }
}
