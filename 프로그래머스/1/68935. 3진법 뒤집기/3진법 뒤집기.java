import java.util.*;

class Solution {
    public int solution(int n) {
        String str = "";
        int answer = 0;
        
        while(n > 0) {
            str += n%3;
            n /= 3;
        }
        StringBuilder sb = new StringBuilder(str);
        //str = sb.reverse().toString();
        
        return Integer.parseInt(str, 3);
    }
}