import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        List<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<name.length; i++) map.put(name[i], yearning[i]);
        
        for(String[] photoNum : photo) {
            int sum = 0;
            for(String person : photoNum) {
                if(map.containsKey(person)) sum += map.get(person);
            }
            answer.add(sum);
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}