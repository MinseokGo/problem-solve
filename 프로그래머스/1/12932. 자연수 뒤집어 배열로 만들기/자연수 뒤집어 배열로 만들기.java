import java.util.*;

class Solution {
    public int[] solution(long n) {
        List<Integer> answer = new ArrayList<>();
        int i=0;
        
        while(n > 0) {
            answer.add((int)(n%10));
            n /= 10;
            i++;
        }
        
        return answer.stream().mapToInt(x -> x).toArray();
    }
}