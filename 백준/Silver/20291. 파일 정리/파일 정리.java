import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> files = new HashMap<>();
        final int times = Integer.parseInt(br.readLine());

        for (int i = 0; i < times; i++) {
            String[] tokens = br.readLine().split("\\.");
            files.put(tokens[1], files.getOrDefault(tokens[1], 0) + 1);
        }

        List<String> fileNames = new ArrayList<>(files.keySet());
        fileNames.sort(Comparator.naturalOrder());

        for (String fileName : fileNames) {
            sb.append(fileName)
                    .append(" ")
                    .append(files.get(fileName))
                    .append("\n");
        }

        System.out.println(sb);
    }
}
