import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sizes = br.readLine().split("\\s");
        Set<String> contains = new HashSet<>();

        final int N = Integer.parseInt(sizes[0]);
        final int M = Integer.parseInt(sizes[1]);
        for (int i = 0; i < N; i++) {
            contains.add(br.readLine());
        }

        int count = 0;
        for (int i = 0; i < M; i++) {
            if (contains.contains(br.readLine())) {
                count++;
            }
        }

        System.out.println(count);
    }
}