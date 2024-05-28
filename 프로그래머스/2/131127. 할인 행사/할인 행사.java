import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        for (int i = 0; i <= discount.length - 10; i++) {
            Map<String, Integer> map = new HashMap<>();
            boolean isPrime = true;
            for (int j = i; j < i + 10; j++) {
                map.put(discount[j], map.getOrDefault(discount[j], 0) + 1);
            }
            for (int j = 0; j < want.length; j++) {
                if (!(number[j] == map.getOrDefault(want[j], 0))) {
                    isPrime = false;
                    continue;
                }
            }
            if (isPrime) answer++;
        }
        
        return answer;
    }
}