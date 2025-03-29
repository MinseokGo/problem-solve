import java.util.*;

class Solution {
    
    public String[] solution(String[] files) {
        Arrays.sort(files, (s1, s2) -> {
            String[] h1 = getHeadAndNumber(s1);
            String[] h2 = getHeadAndNumber(s2);
            
            int headCompare = h1[0].compareToIgnoreCase(h2[0]);
            if (headCompare != 0) {
                return headCompare;
            }
            
            int number1 = Integer.parseInt(h1[1]);
            int number2 = Integer.parseInt(h2[1]);
            return Integer.compare(number1, number2);
        });
        
        return files;
    }
    
    private String[] getHeadAndNumber(String str) {
        int start = -1;
        int end = -1;
        String head = "";
        String number = "";
        
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (start < 0 && Character.isDigit(chars[i])) {
                start = i;
                head = str.substring(0, start);
            } else if (start >= 0 && !Character.isDigit(chars[i])) {
                end = i;
                number = str.substring(start, end);
                break;
            }
        }
        
        if (end < 0) {
            number = str.substring(start, str.length());
        }
        
        return new String[] {head, number};
    }
}