import java.util.*;

class Solution {
    
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        
        int quotient = s / n;
        int mod = s % n;
        
        if (quotient == 0) {
            return new int[] {-1};
        }
        
        Arrays.fill(answer, quotient);
        
        int index = n - 1;
        for (int i = 0; i < mod; i++) {
            answer[index--] += 1;
        }
        
        return answer;
    }
}