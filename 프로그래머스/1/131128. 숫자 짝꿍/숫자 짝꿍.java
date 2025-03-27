import java.util.*;

class Solution {
    
    public String solution(String X, String Y) {
        StringBuilder sb = new StringBuilder();
        int[] xCount =  new int[10];
        int[] yCount =  new int[10];
        
        for (char ch : X.toCharArray()) {
            xCount[ch - '0'] += 1;
        }
        
        for (char ch : Y.toCharArray()) {
            yCount[ch - '0'] += 1;
        }
        
        for (int i = 9; i >= 0; i--) {
            int max = Math.min(xCount[i], yCount[i]);
            
            while (max > 0) {
                sb.append(i);
                max -= 1;
            }
        }
        
        String answer = sb.toString();
        
        if (answer.isEmpty()) {
            return "-1";
        }
        if (answer.startsWith("0")) {
            return "0";
        }
        
        return answer;
    }
}