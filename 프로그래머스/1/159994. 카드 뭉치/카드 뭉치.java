import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        int idx1 = 1;
        int idx2 = 1;
        
        for(int i=0; i<cards1.length; i++) map1.put(cards1[i], i + 1);
        for(int i=0; i<cards2.length; i++) map2.put(cards2[i], i + 1);
        
        
        for(String str : goal) {
            if(map1.containsKey(str)) {
                if(map1.get(str) == idx1) {
                    idx1++;
                } else {
                    return "No";
                }
            } else if(map2.containsKey(str)) {
                if(map2.get(str) == idx2) {
                    idx2++;
                } else {
                    return "No";
                }
                
            }
        }
        
        return answer;
    }
}