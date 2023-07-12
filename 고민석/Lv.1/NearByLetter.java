import java.util.*;

class Solution {
    public int[] solution(String s) {
        List<Integer> answer = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(!map.containsKey(c)) {  //없으면 맵핑하고 -1 추가
                map.put(c, i + 1);
                answer.add(-1);
            } else {  //있으면 인덱스 차이값을 구하고 새로운 인덱스 갱신
                int num = i + 1 - map.get(c);
                map.put(c, i + 1);
                answer.add(num);
            }
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
