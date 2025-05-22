import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] server = new int[24];
        int serverCount = 0;
        
        for (int i = 0; i < players.length; i++) {
            if (i >= k) {
                serverCount -= server[i - k];
            }
            
            int requiredServer = players[i] / m;
            if (requiredServer > serverCount) {
                server[i] = requiredServer - serverCount;
                serverCount = requiredServer;
                answer += server[i];
            }
        }
        
        return answer;
    }
}