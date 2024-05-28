import java.util.*;

class Solution {
    public String solution(String[] participants, String[] completions) {
        Map<String, Integer> map = new HashMap<>();
        
        Arrays.stream(completions)
            .forEach(completion -> 
                     map.put(completion, map.getOrDefault(completion, 0) + 1));
        
        for (String participant : participants) {
            if (!map.containsKey(participant) ||
                 map.get(participant) == 0) {
                
                return participant;
            }
            map.put(participant, map.get(participant) - 1);
        }
        
        return "null";
    }
}