import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String answer = "";
        
        for(int i=0; i<skip.length(); i++)
            alphabet = alphabet.replace(Character.toString(skip.charAt(i)), "");
        
        for(int i=0; i<s.length(); i++) {
            int idx = alphabet.indexOf(s.charAt(i)) + index;
            answer += alphabet.charAt(idx% alphabet.length());
        }
        
        
        return answer;
    }
}