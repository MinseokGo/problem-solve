import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();
        
        //옷 종류마다 카운트 있으면 +1 없으면 1
        for(String[] set : clothes)
            map.put(set[1], map.getOrDefault(set[1], 1) + 1);
        
        //종류별로 모든 경우의 수 계산
        for(String key : map.keySet())
            answer *= map.get(key);
        
        //아무것도 입지 않은 경우의 수 제외
        return answer - 1;
    }
}
