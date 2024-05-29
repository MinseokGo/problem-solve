import java.util.*;

class Solution {
    
    static Map<Integer, HashMap<String, Integer>> courseMap = new HashMap<>();
    
    public String[] solution(String[] orders, int[] courses) {
        for (int course : courses) {
            courseMap.put(course, new HashMap<>());
        }
        
        for (String order : orders) {
            char[] chars = order.toCharArray();
            Arrays.sort(chars);
            combinations(0, chars, "");
        }
        
        List<String> answer = new ArrayList<>();
        for (Map<String, Integer> course : courseMap.values()) {
            course.values().stream()
                .max(Comparator.comparingInt(i -> i))
                .ifPresent(count -> course.entrySet()
                          .stream()
                          .filter(entry -> count.equals(
                              entry.getValue()) && count > 1)
                          .forEach(entry -> answer.add(entry.getKey())));
        }
        
        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }
    
    private void combinations(int index, char[] chars, String order) {
        if (courseMap.containsKey(order.length())) {
            Map<String, Integer> map = courseMap.get(order.length());
            map.put(order, map.getOrDefault(order, 0) + 1);
        }
        
        for (int i = index; i < chars.length; i++) {
            combinations(i + 1, chars, order + chars[i]);
        }
    }
}