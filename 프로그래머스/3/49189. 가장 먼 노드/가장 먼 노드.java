import java.util.*;

class Solution {
    
    static List<Integer>[] graph;
    static int[] distance;
    
    public int solution(int n, int[][] edges) {
        graph = new ArrayList[n + 1];
        
        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        bfs(n);
        
        int max = Arrays.stream(distance)
            .max()
            .getAsInt();
        
        int count = 0;
        for (int i = 2; i < n + 1; i++) {
            if (max == distance[i]) {
                count++;
            }
        }
        
        return count;
    }
    
    private void bfs(int n) {
        distance = new int[n + 1];
        Arrays.fill(distance, -1);
        distance[1] = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            
            for (int next : graph[node]) {
                if (distance[next] == -1) {
                    queue.add(next);
                    distance[next] = distance[node] + 1;
                }
            }
        }
    }
}