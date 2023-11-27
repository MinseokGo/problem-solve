import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        HashMap<Character, Integer> map = new HashMap<>();
        List<Integer> answer = new ArrayList<>();
        
        for(String key : keymap) {
            for(int i=0; i<key.length(); i++) {
                char c = key.charAt(i);
                if(!map.containsKey(c)) {
                    map.put(c, i + 1);
                } else if(map.containsKey(c) && map.get(c) > i + 1) {
                    map.put(c, i + 1);
                }
            }
        }
        
        for(String target : targets) {
            int cnt = 0;
            int isPrime = 1;
            for(int i=0; i<target.length(); i++) {
                char c = target.charAt(i);
                if(map.containsKey(c)) { 
                    cnt += map.get(c);
                } else {
                    answer.add(-1);
                    isPrime = 0;
                    break;
                }
            }
            if(isPrime == 1) answer.add(cnt);
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}