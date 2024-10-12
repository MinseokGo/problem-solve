import java.util.*;

class Solution {
    
    static int answer = Integer.MAX_VALUE;
    static int N;
    
    public int solution(int n, int[][] wires) {
        HashSet[] nodes = new HashSet[n + 1];
        N = n;
        
        for (int i = 1; i <= n; i++) {
            nodes[i] = new HashSet<>();
        }
        
        for (int[] wire : wires) {
            nodes[wire[0]].add(wire[1]);
            nodes[wire[1]].add(wire[0]);
        }
        
        boolean[] visited = new boolean[n + 1];
        dfs(nodes, 1, visited);
        
        return answer;
    }
    
    private int dfs(HashSet[] nodes, int start, boolean[] visited) {
        int result = 1;
        visited[start] = true;
        
        Set<Integer> node = nodes[start];
        for (int number : node) {
            if (!visited[number]) {
                int count = dfs(nodes, number, visited);
                answer = Math.min(answer, Math.abs(N - count * 2));
                result += count;
            }
        }
        
        return result;
    }
}