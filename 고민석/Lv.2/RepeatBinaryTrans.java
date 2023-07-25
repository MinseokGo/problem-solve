import java.util.*;

class Solution {
    static int cnt = 0;
    static int times = 0;
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        baseTwo(s);
        
        answer[0] = times;
        answer[1] = cnt;
        
        return answer;
    }
    
    static String baseTwo(String s) {
        if(s.equals("1")) return "1";  //"1"이 되면 재귀 종료
        int noZero = s.replace("0", "").length();  //0이 제거된 문자열의 길이
        cnt += s.length() - noZero;  //0이 제거된 개수 카운트
        times++;  //변환 반복 횟수 카운트
        
        String binaryString = Integer.toBinaryString(noZero);
        
        return baseTwo(binaryString);
    }
}
