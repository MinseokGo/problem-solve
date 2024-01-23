import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokens = new StringTokenizer(br.readLine());
        final int sLength = Integer.parseInt(tokens.nextToken());
        final int pLength = Integer.parseInt(tokens.nextToken());
        final String s = br.readLine();

        tokens = new StringTokenizer(br.readLine());
        int[] check = new int[4];
        int[] counts = new int[4];
        boolean isPrime = true;
        int count = 0;

        for (int i = 0; i < 4; i++) {
            check[i] = Integer.parseInt(tokens.nextToken());
        }

        for (int i = 0; i < pLength; i++) {
            final char ch = s.charAt(i);
            if (ch == 'A') {
                counts[0]++;
            }
            if (ch == 'C') {
                counts[1]++;
            }
            if (ch == 'G') {
                counts[2]++;
            }
            if (ch == 'T') {
                counts[3]++;
            }
        }

        for (int i = 0; i < 4; i++) {
            if (counts[i] < check[i]) {
                isPrime = false;
            }
        }

        if (isPrime) {
            count++;
        }

        for (int i = pLength; i < sLength; i++) {
            int index = i - pLength;
            final char ch = s.charAt(index);
            if (ch == 'A') {
                counts[0]--;
            }
            if (ch == 'C') {
                counts[1]--;
            }
            if (ch == 'G') {
                counts[2]--;
            }
            if (ch == 'T') {
                counts[3]--;
            }

            final char newCh = s.charAt(i);
            if (newCh == 'A') {
                counts[0]++;
            }
            if (newCh == 'C') {
                counts[1]++;
            }
            if (newCh == 'G') {
                counts[2]++;
            }
            if (newCh == 'T') {
                counts[3]++;
            }

            isPrime = true;
            for (int j = 0; j < 4; j++) {
                if (counts[j] < check[j]) {
                    isPrime = false;
                }
            }

            if (isPrime) {
                count++;
            }
        }

        System.out.println(count);
    }
}