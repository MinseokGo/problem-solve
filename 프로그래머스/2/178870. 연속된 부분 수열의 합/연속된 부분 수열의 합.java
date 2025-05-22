import java.util.*;

class Solution {
    
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        answer[1] = Integer.MAX_VALUE;
        
        int sum = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < sequence.length; i++) {
            sum += sequence[i];
            while (sum > k) {
                sum -= sequence[left];
                left += 1;
            }
            
            if (sum == k) {
                right = i;
                if (right - left < answer[1] - answer[0]) {
                    answer[0] = left;
                    answer[1] = right;
                }
            }
        }
        
        return answer;
    }
}
