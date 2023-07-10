import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> map = new HashMap<>();

        //순위대로 mapping
        for(int i=0; i<players.length; i++) map.put(players[i], i+1);
        
        for(String call : callings) {
            int idx = map.get(call) - 1;  //추월한 선수의 순위를 얻음(인덱스이므로 -1)
            
            players[idx] = players[idx - 1];  //앞 순위의 선수를 뒷 순위로
            players[idx - 1] = call;  //뒷 순위의 선수를 앞 순위로
            
            map.put(players[idx - 1], idx);   //해당 선수들의 순위 값을 변경해줌
            map.put(players[idx], idx + 1);
        }
        
        return players;
    }
}
