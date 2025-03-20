import java.util.*;

class Solution {
    
    public int solution(String str1, String str2) {
        int answer = 0;
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        Map<String, Integer> totalMinMap = new HashMap<>();
        Map<String, Integer> totalMaxMap = new HashMap<>();
        for (int i = 0; i < str1.length() - 1; i++) {
            String sub = str1.substring(i, i + 2);
            if ('a' <= sub.charAt(0) && sub.charAt(0) <= 'z'
               && 'a' <= sub.charAt(1) && sub.charAt(1) <= 'z') {
                map1.put(sub, map1.getOrDefault(sub, 0) + 1);
            }
        }
        
        for (int i = 0; i < str2.length() - 1; i++) {
            String sub = str2.substring(i, i + 2);
            if ('a' <= sub.charAt(0) && sub.charAt(0) <= 'z'
               && 'a' <= sub.charAt(1) && sub.charAt(1) <= 'z') {
                map2.put(sub, map2.getOrDefault(sub, 0) + 1);
            }
        }
        
        if (map1.size() == 0 && map2.size() == 0) {
            return 65536;
        }
        
        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            String key = entry.getKey();
            if (map2.containsKey(key)) {
                if (map1.get(key) >= map2.get(key)) {
                    totalMinMap.put(key, map2.get(key));
                    totalMaxMap.put(key, map1.get(key));
                } else {
                    totalMinMap.put(key, map1.get(key));
                    totalMaxMap.put(key, map2.get(key));
                }
            } else {
                totalMaxMap.put(key, entry.getValue());
            }
        }
        
        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            String key = entry.getKey();
            if (!map1.containsKey(key)) {
                totalMaxMap.put(key, entry.getValue());
            }
        }
        
        int min = totalMinMap.entrySet().stream()
            .mapToInt(entry -> entry.getValue())
            .sum();
        
        int max = totalMaxMap.entrySet().stream()
            .mapToInt(entry -> entry.getValue())
            .sum();
        
        System.out.println(min + ", " + max);
        
        return 65536 * min / max;
    }
}