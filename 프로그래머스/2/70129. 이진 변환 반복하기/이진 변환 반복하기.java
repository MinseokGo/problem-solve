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
        if(s.equals("1")) return "1";
        int noZero = s.replace("0", "").length();
        cnt += s.length() - noZero;
        times++;
        
        String binaryString = Integer.toBinaryString(noZero);
        
        return baseTwo(binaryString);
    }
}