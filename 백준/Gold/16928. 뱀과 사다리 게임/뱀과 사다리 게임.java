import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Main {

    static int rollCount = 0;
    static boolean[] visited = new boolean[101];
    static Map<Integer, Integer> things = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("\\s");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        for (int i = 0; i < N + M; i++) {
            input = br.readLine().split("\\s");
            things.put(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        }

        bfs();
        System.out.println(rollCount);
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            rollCount++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int nowPosition = queue.poll();

                for (int j = 1; j <= 6; j++) {
                    int nextPosition = nowPosition + j;

                    if (nextPosition == 100) {
                        return;
                    }

                    if (nextPosition > 100 || visited[nextPosition]) {
                        continue;
                    }

                    visited[nextPosition] = true;
                    if (things.containsKey(nextPosition)) {
                        nextPosition = things.get(nextPosition);
                    }
                    queue.add(nextPosition);
                }
            }
        }
    }
}
