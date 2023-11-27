import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        List<Integer> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<numbers.length-1; i++) {
            for(int j=i+1; j<numbers.length; j++) {
                int num = numbers[i] + numbers[j];
                if(!map.containsKey(String.valueOf(num))) {
                    map.put(String.valueOf(num), 1);
                    list.add(num);
                }
            }
        }
        
        Collections.sort(list);
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}