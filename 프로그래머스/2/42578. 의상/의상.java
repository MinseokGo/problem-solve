import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String[] set : clothes)
            map.put(set[1], map.getOrDefault(set[1], 1) + 1);
        
        for(String key : map.keySet())
            answer *= map.get(key);
        
        return answer - 1;
    }
}