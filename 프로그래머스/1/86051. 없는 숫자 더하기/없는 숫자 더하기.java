import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int answer = 45;    //0~9합
        
        return answer - Arrays.stream(numbers).sum();
    }
}

// HashMap<Integer, Boolean> map = new HashMap<>();
        
//         for(int i=0; i<10; i++) map.put(i, false);
        
//         for(int num : numbers) {
//             if(map.containsKey(num)) map.put(num, true);
//         }
        
//         for(Integer key : map.keySet()) {
//             if(!map.get(key)) answer += key;
//         }
        