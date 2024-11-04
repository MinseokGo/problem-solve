import java.io.*;
import java.util.*;

class Solution {
	public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        int n = Integer.parseInt(bufferedReader.readLine());
        
        for (int i = 0; i < n; i++) {
            String[] input = bufferedReader.readLine().split("\\s");
            int N = Integer.parseInt(input[0]);
            int P = Integer.parseInt(input[1]);
            
            int sum = 0;
            for (int j = 1; j <= N; j++) {
                sum += j;
                if (sum == P) {
                    sum -= 1;
                }
            }
            stringBuilder.append(sum)
                .append("\n");
        }
        
        System.out.println(stringBuilder);
    }
}