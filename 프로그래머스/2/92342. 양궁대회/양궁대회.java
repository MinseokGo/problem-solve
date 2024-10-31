import java.util.*;

class Solution {
    
    private static int max = 0;
    private static int[] apeach;
    private static int[] answer;
    
    public int[] solution(int n, int[] info) {
        apeach = info;
        max = 0;
        dfs(n, 0, new int[11]);
        
        return max == 0 ? new int[] { -1 } : answer;
    }
    
    private void dfs(int n, int index, int[] ryan) {
        if (n == 0) {
            calculateSub(ryan.clone());
            return ;
        }
        
        for (int i = index; i <= 10; i++) {
            int count = Math.min(n, apeach[i] + 1);
            ryan[i] = count;
            dfs(n - count, i + 1, ryan);
            ryan[i] = 0;
        }
    }
    
    private void calculateSub(int[] ryan) {
        int score = getScore(ryan);
        
        if (score > max) {
            max = score;
            answer = ryan;
        } else if (max > 0 && score == max) {
            for (int i = 10; i >= 0; i--) {
                if (ryan[i] != answer[i]) {
                    if (ryan[i] > answer[i]) {
                        answer = ryan;
                    }
                    break;
                }
            }
        }
    }
    
    private int getScore(int[] ryan) {
        int score = 0;
        for (int i = 0; i < ryan.length; i++) {
            if (ryan[i] + apeach[i] > 0) {
                score += ryan[i] > apeach[i] ? (10 - i) : -(10 - i);
            }
        }
        return score;
    }
}