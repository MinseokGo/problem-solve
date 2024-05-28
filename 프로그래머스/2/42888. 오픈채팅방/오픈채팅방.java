import java.util.*;

class Solution {
    public String[] solution(String[] records) {
        Map<String, String> map = new HashMap<>();
        List<String> answer = new ArrayList<>();
        
        for (String record : records) {
            String[] splits = record.split("\\s");
            if (splits.length == 3) {
                map.put(splits[1], splits[2]);
            } 
        }
        
        for (String record : records) {
            String[] splits = record.split("\\s");
            if (splits[0].startsWith("E")) {
                answer.add(map.get(splits[1]) + "님이 들어왔습니다.");
            }
            if (splits[0].startsWith("L")) {
                answer.add(map.get(splits[1]) + "님이 나갔습니다.");
            }
        }
        
        return answer.toArray(new String[answer.size()]);
    }
}