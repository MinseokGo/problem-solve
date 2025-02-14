import java.util.*;

class Solution {
    
    public int solution(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n + 1];
        
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        int[] distance = bfs(graph, n);
        
        int maxDistance = Arrays.stream(distance)
            .max()
            .getAsInt();

        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (distance[i] == maxDistance) {
                count++;
            }
        }

        return count;
    }

    private int[] bfs(List<Integer>[] graph, int n) {
        int[] distance = new int[n + 1];
        Arrays.fill(distance, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        distance[1] = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int next : graph[node]) {
                if (distance[next] == -1) { // 방문하지 않은 노드
                    queue.add(next);
                    distance[next] = distance[node] + 1;
                }
            }
        }

        return distance;
    }
}
