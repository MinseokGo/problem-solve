import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> files = new TreeMap<>();
        final int times = Integer.parseInt(br.readLine());

        for (int i = 0; i < times; i++) {
            StringTokenizer tokens = new StringTokenizer(br.readLine(), "\\.");
            final String trash = tokens.nextToken();
            final String need = tokens.nextToken();
            files.put(need, files.getOrDefault(need, 0) + 1);
        }

        for (Map.Entry<String, Integer> file : files.entrySet()) {
            sb.append(file.getKey())
                    .append(" ")
                    .append(file.getValue())
                    .append("\n");
        }

        System.out.println(sb);
    }
}
