import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        HashSet[] nodes = new HashSet[n + 1];
        
        for (int i = 1; i <= n; i++) {
            nodes[i] = new HashSet<>();
        }
        
        for (int[] wire : wires) {
            nodes[wire[0]].add(wire[1]);
            nodes[wire[1]].add(wire[0]);
        }
        
        for (int[] wire : wires) {
            int node1 = wire[0];
            int node2 = wire[1];
            
            nodes[node1].remove(node2);
            nodes[node2].remove(node1);
            
            boolean[] visited = new boolean[n + 1];
            int first = dfs(nodes, node1, 0, visited);
            int second = n - first;
            
            answer = Math.min(answer, Math.abs(first - second));
            
            nodes[node1].add(node2);
            nodes[node2].add(node1);
        }
        
        return answer;
    }
    
    private int dfs(HashSet[] nodes, int start, int count, boolean[] visited) {
        int result = 1;
        visited[start] = true;
        
        Set<Integer> node = nodes[start];
        for (int number : node) {
            if (!visited[number]) {
                result += dfs(nodes, number, count + 1, visited);
            }
        }
        
        return result;
    }
}