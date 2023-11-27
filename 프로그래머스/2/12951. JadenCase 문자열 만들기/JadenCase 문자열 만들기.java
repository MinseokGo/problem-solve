import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        s = s.toLowerCase();
        StringTokenizer st = new StringTokenizer(s, " ", true);
        
        while(st.hasMoreTokens()) {
            StringBuilder sb = new StringBuilder(st.nextToken());
            System.out.println(sb);
            answer += sb.replace(0, 1, Character.toString(sb.charAt(0)).toUpperCase());
        }
        
        return answer;
    }
}