import java.util.*;

class Solution {
    public boolean solution(String s) {
        boolean answer = false;
        
        if(!(4 == s.length() || s.length() == 6)) {
            return answer;
        }
        s = s.replaceAll("[0-9]", "");
        
        if(s.length() == 0) answer = true;
        
        return answer;
    }
}