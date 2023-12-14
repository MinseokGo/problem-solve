import java.util.*;

class Solution {
    public String[] solution(String[] records) {
        List<String> answer = new ArrayList<>();
        Map<String, String> names = new HashMap<>();
        
        for (String record : records) {
            String[] strings = record.split(" ");
            if (strings.length == 3) {
                names.put(strings[1], strings[2]);
            }
        }
        
        for (String record : records) {
            String[] strings = record.split("\\s");
            if (strings[0].equals("Enter")) {
                String name = names.get(strings[1]);
                answer.add(name + "님이 들어왔습니다.");
            }
            if (strings[0].equals("Leave")) {
                String name = names.get(strings[1]);
                answer.add(name + "님이 나갔습니다.");
            }
        }
        
        return answer.toArray(new String[answer.size()]);
    }
}