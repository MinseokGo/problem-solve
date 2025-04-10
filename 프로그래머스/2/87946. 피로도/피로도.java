import java.util.*;

class Solution {
    
    static int answer = 0;

    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        dfs(k, dungeons, visited, 0);
        return answer;
    }
    
    private void dfs(int hp, int[][] dungeons, boolean[] visited, int count) {
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && hp >= dungeons[i][0]) {
                visited[i] = true;
                dfs(hp - dungeons[i][1], dungeons, visited, count + 1);
                visited[i] = false;
            }
        }
        answer = Math.max(answer, count);
    }
}