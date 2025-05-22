import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        Map<Integer, Integer> server =  new HashMap<>();
        int answer = 0;

        int serverCount = 0;
        for (int i = 0; i < players.length; i++) {
            if (server.containsKey(i - k)) {
                serverCount -= server.get(i - k);
            }
            
            int currentPlayers = players[i];
            if (currentPlayers / m > serverCount) {
                int scaleUpCount = currentPlayers / m - serverCount;
                server.put(i, scaleUpCount);
                serverCount += scaleUpCount;
                answer += scaleUpCount;
            }
        }
        
        return answer;
    }
}