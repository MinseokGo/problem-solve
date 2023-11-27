import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = n+1;
        
        while(true) {
            int nLen = Integer.bitCount(n);
            int aLen = Integer.bitCount(answer);
            if(nLen == aLen) break;
            answer++;
        }
        
        return answer;
    }
}