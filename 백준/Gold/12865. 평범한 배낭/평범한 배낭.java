import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split("\\s");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        int[] dp = new int[K + 1];

        for (int i = 0; i < N; i++) {
            input = bufferedReader.readLine().split("\\s");
            int W = Integer.parseInt(input[0]);
            int V = Integer.parseInt(input[1]);

            for (int j = K; j >= W; j--) {
                dp[j] = Math.max(dp[j], dp[j - W] + V);
            }
        }

        System.out.println(dp[K]);
    }
}
