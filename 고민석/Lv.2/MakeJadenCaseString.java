import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";

        //전부 소문자로
        s = s.toLowerCase();
        //공백이 연속으로 나올 경우를 고려해서 공백도 담아줌
        //예를들면 follower공백공백hello일 경우
        //Follower공백공백Hello로 바꿔야함
        StringTokenizer st = new StringTokenizer(s, " ", true);
        
        while(st.hasMoreTokens()) {
            StringBuilder sb = new StringBuilder(st.nextToken());
            answer += sb.replace(0, 1, Character.toString(sb.charAt(0)).toUpperCase());  //첫번째 글자를 대문자로 치환하고 answer에 추가
        }
        
        return answer;
    }
}
