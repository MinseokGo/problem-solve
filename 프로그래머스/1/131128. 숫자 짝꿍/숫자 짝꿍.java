import java.util.*;

class Solution {
    
    public String solution(String X, String Y) {
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        
        for (char ch : Y.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1); 
        }
        
        for (char ch : X.toCharArray()) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
                sb.append(ch);
                if (map.get(ch) == 0) {
                    map.remove(ch);
                }
            }
        }
        
        char[] chars = sb.toString().toCharArray();
        Arrays.sort(chars);
        
        StringBuilder sortedSb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            sortedSb.append(chars[i]);
        }
        
        String answer = sortedSb.reverse().toString();
        
        if (answer.length() == 0) {
            return "-1";
        } else if (answer.startsWith("0")) {
            return "0";
        }
        
        return answer;
    }
}