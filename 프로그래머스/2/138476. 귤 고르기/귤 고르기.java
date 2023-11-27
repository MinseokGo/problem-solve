import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<tangerine.length; i++) 
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        
        for(Integer key : map.keySet()) 
            list.add(map.get(key));
        
        Collections.sort(list, Collections.reverseOrder());
        
        int cnt = 0;
        for(int i=0; i<list.size(); i++) {
            if(cnt >= k) {
                 break;
            } else {
                cnt += list.get(i);
                answer++;
            }
            
        }
        
        return answer;
    }
}