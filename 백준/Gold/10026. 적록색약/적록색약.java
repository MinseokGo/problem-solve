import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    static int N;
    static char[][] map1;
    static char[][] map2;
    static boolean[][] visited1;
    static boolean[][] visited2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map1 = new char[N][N];
        map2 = new char[N][N];
        visited1 = new boolean[N][N];
        visited2 = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                char ch = input.charAt(j);
                map1[i][j] = ch;
                if (ch == 'R' || ch == 'G') {
                    map2[i][j] = 'R';
                } else {
                    map2[i][j] = ch;
                }
            }
        }

        int count1 = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited1[i][j]) {
                    count1 += 1;
                    visited1[i][j] = true;
                    dfs(map1, visited1, i, j);
                }
            }
        }

        int count2 = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited2[i][j]) {
                    count2 += 1;
                    visited2[i][j] = true;
                    dfs(map2, visited2, i, j);
                }
            }
        }

        System.out.println(count1 + " " + count2);
    }

    private static void dfs(char[][] map, boolean[][] visited, int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (isValidPosition(nx, ny) && !visited[nx][ny] && map[x][y] == map[nx][ny]) {
                visited[nx][ny] = true;
                dfs(map, visited, nx, ny);
            }
        }
    }

    private static boolean isValidPosition(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }
}
