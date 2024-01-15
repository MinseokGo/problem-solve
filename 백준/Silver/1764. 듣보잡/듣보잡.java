import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer tokens = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(tokens.nextToken());
        final int M = Integer.parseInt(tokens.nextToken());

        Set<String> names = new HashSet<>();
        for (int i = 0; i < N; i++) {
            final String name = br.readLine();
            names.add(name);
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            final String name = br.readLine();
            if (!names.add(name)) {
                result.add(name);
            }
        }

        Collections.sort(result);
        sb.append(result.size())
                .append("\n");

        for (String name : result) {
            sb.append(name)
                    .append("\n");
        }

        System.out.println(sb);
    }
}
