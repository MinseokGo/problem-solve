import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    static boolean isPossible;
    static String S;
    static String T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        T = br.readLine();

        dfs(T);

        if (isPossible) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    private static void dfs(String current) {
        if (isPossible) {
            return;
        }

        if (current.length() < S.length()) {
            return;
        }

        if (current.equals(S)) {
            isPossible = true;
            return;
        }

        if (current.charAt(current.length() - 1) == 'A') {
            dfs(current.substring(0, current.length() - 1));
        }
        if (current.charAt(0) == 'B') {
            StringBuilder sb = new StringBuilder(current.substring(1));
            dfs(sb.reverse().toString());
        }
    }
}
