import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        char[] chs = s.toCharArray();
        int idx = 0;
        
        for(int i=0; i<chs.length; i++) {
            if(chs[i] == ' ') {
                idx = 0;
                continue;
            }
            
            if(idx % 2 == 0) {
                chs[i] = Character.toUpperCase(chs[i]);
            } else {
                chs[i] = Character.toLowerCase(chs[i]);
            }
            idx++;
        }
        
        return new String(chs);
    }
}