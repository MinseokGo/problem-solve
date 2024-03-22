import java.util.*;

class Solution {
    private static int[] parent;
    
    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, (cost1, cost2) -> Integer.compare(cost1[2], cost2[2]));
        
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        int answer = 0;
        int edges = 0;
        
        for (int[] edge : costs) {
            if (edges == n - 1) {
                break;
            }
            
            // 두 섬이 연결 되어 있지 않다면
            if (find(edge[0]) != find(edge[1])) {
                // 두 섬을 연결
                union(edge[0], edge[1]);
                // 현재 다리의 건설 비용을 총비용에 추가
                answer += edge[2];
                // 다리 개수 증가
                edges++;
            }
        }
        
        return answer;
    }
    
    // 루트 노드 찾기
    private static int find(final int x) {
        if (parent[x] == x) {
            return x;
        }
        // 경로 압축 : x의 부모를 루트 노드로 설정
        return parent[x] = find(parent[x]);
    }
    
    // 집합 합치기
    private static void union(final int x, final int y) {
        final int root1 = find(x);
        final int root2 = find(y);
        parent[root2] = root1;
    }
}