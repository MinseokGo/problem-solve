import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        HashMap<Character, Integer> map = new HashMap<>();
        List<Integer> answer = new ArrayList<>();
        
        //모든 키에 대해 최소로 눌러야하는 값을 매핑
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
        
        //모든 타겟에 대해 최솟값을 카운트
        for(String target : targets) {
            int cnt = 0;
            int isPrime = 1;
            for(int i=0; i<target.length(); i++) {
                char c = target.charAt(i);
                if(map.containsKey(c)) { 
                    cnt += map.get(c);
                } else {    //키가 없으면 -1을 추가하고, 반복문 탈출
                    answer.add(-1);
                    isPrime = 0;
                    break;
                }
            }
            if(isPrime == 1) answer.add(cnt);   //모든 키가 있을 때만 카운트 추가
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
