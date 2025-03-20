import java.util.*;

class Solution {
    
    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        Map<String, Integer> map1 = extract(str1);
        Map<String, Integer> map2 = extract(str2);
        
        Set<String> allKeys = new HashSet<>();
        allKeys.addAll(map1.keySet());
        allKeys.addAll(map2.keySet());
        
        int intersection = 0;
        int union = 0;
        for (String key : allKeys) {
            int count1 = map1.getOrDefault(key, 0);
            int count2 = map2.getOrDefault(key, 0);
            
            intersection += Math.min(count1, count2);
            union += Math.max(count1, count2);
        }
        
        if (intersection == 0 && union == 0) {
            return 65536;
        }
        
        return 65536 * intersection / union;
    }
    
    private Map<String, Integer> extract(String str) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length() - 1; i++) {
            String sub = str.substring(i, i + 2);
            if (Character.isLetter(sub.charAt(0)) 
                && Character.isLetter(sub.charAt(1))) {
                map.put(sub, map.getOrDefault(sub, 0) + 1);
            }
        }
        return map;
    }
}