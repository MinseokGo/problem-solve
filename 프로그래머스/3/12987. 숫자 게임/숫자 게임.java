import java.util.*;

class Solution {
    
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int a = 0;
        int b = 0;
        while (a < A.length && b < B.length) {
            if (B[b] > A[a]) {
                a += 1;
                answer += 1;
            }
            b += 1;
        }
        
        return answer;
    }
}
