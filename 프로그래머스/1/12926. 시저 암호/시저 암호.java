import java.util.*;

class Solution {
    public String solution(String s, int n) {
        String[] low = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
                       "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u",
                       "v", "w", "x", "y", "z"};
        String answer = "";
        for (int i = 0; i < s.length(); i++) {
            if (65 <= s.charAt(i) && s.charAt(i) <= 90) {
                answer += low[((s.charAt(i) + n) - 65) % 26].toUpperCase();
            }
            if (97 <= s.charAt(i) && s.charAt(i) <= 122) {
                answer += low[((s.charAt(i) + n) - 97) % 26];
            }
            if (s.charAt(i) == ' ') {
                answer += s.charAt(i);
            }
        }
        
        return answer;
    }
}