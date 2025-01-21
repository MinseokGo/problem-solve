import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static final int[] dx = {1, -1, 0, 0};
    static final int[] dy = {0, 0, 1, -1};

    static int[][] map;
    static boolean[][] visited;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("\\s");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String numbers = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = Character.getNumericValue(numbers.charAt(j));
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(0, 0, 1));
        visited[0][0] = true;
        int answer = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            Position position = queue.poll();

            if (position.x == N - 1 && position.y == M - 1) {
                answer = Math.min(answer, position.count);
            }

            for (int i = 0; i < 4; i++) {
                int nx = position.x + dx[i];
                int ny = position.y + dy[i];

                if (isValidPosition(nx, ny) && map[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new Position(nx, ny, position.count + 1));
                }
            }
        }

        return answer;
    }

    private static boolean isValidPosition(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < N && ny < M;
    }

    static class Position {

        int x;
        int y;
        int count;

        public Position(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
