import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Main {

    static final int MAX_POSITION = 100_000;

    static int N;
    static int K;
    static int answer = Integer.MAX_VALUE;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("\\s");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        visited = new boolean[MAX_POSITION + 1];
        bfs();
        System.out.println(answer);
    }

    private static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(N, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            visited[node.x] = true;

            if (node.x == K) {
                answer = Math.min(node.time, answer);
            }

            if (node.x * 2 <= MAX_POSITION && !visited[node.x * 2]) {
                queue.add(new Node(node.x * 2, node.time));
            }
            if (node.x + 1 <= MAX_POSITION && !visited[node.x + 1]) {
                queue.add(new Node(node.x + 1, node.time + 1));
            }
            if (node.x - 1 >= 0 && !visited[node.x - 1]) {
                queue.add(new Node(node.x - 1, node.time + 1));
            }
        }
    }

    static class Node {

        int x;
        int time;

        Node(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }
}
