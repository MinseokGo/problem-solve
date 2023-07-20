import java.util.*;

class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 123456789;
        
        for(int i=0; i<signs.length; i++) {
            if(!signs[i]) absolutes[i] *= -1;
        }
        
        return Arrays.stream(absolutes).sum();
    }
}

// class Solution {
//     public int solution(int[] absolutes, boolean[] signs) {
//         int answer = 0;
        
//         for(int i=0; i<signs.length; i++)
//             answer += absolutes[i] * (signs[i] ? 1 : -1);
//
        
//         return answer;
//     }
// }
