import java.util.*;

class Solution {
    
    private static int[] parent;
        
    public int solution(int n, int[][] costs) {
        int answer = 0;
        Arrays.sort(costs, (c1, c2) -> Integer.compare(c1[2], c2[2]));
        
        parent = new int[n + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        
        for (int[] cost : costs) {
            if (Integer.compare(find(cost[0]), find(cost[1])) != 0) {
                union(cost[0], cost[1]);
                answer += cost[2];
            }
        }
        
        return answer;
    }
    
    private int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        parent[x] = find(parent[x]);
        return parent[x];
    }
    
    private void union(int a, int b) {
        int root1 = find(a);
        int root2 = find(b);
        parent[root2] = root1;
    }
}