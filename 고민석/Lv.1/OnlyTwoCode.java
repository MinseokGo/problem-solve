import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String answer = "";

        //skip에 있는 문자 제거
        for(int i=0; i<skip.length(); i++)
            alphabet = alphabet.replace(Character.toString(skip.charAt(i)), "");

        //변환할 문자의 인덱스를 찾고, 이동할 인덱스를 더해준 다음
        //answer에 해당 인덱스의 문자를 더함
        for(int i=0; i<s.length(); i++) {
            int idx = alphabet.indexOf(s.charAt(i)) + index;
            answer += alphabet.charAt(idx% alphabet.length());
        }
        
        return answer;
    }
}
