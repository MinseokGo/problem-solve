import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<players.length; i++) map.put(players[i], i+1);
        
        for(String call : callings) {
            int idx = map.get(call) - 1;
            
            players[idx] = players[idx - 1];
            players[idx - 1] = call;
            
            map.put(players[idx - 1], idx);
            map.put(players[idx], idx + 1);
        }
        
        return players;
    }
}