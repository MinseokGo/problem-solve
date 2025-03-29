import java.util.*;

class Solution {
    
    public String[] solution(String[] files) {
        Arrays.sort(files, (s1, s2) -> {
            String[] headAndNumber1 = getHeadAndNumber(s1);
            String head1 = headAndNumber1[0];
            String number1 = headAndNumber1[1];
            
            String[] headAndNumber2 = getHeadAndNumber(s2);
            String head2 = headAndNumber2[0];
            String number2 = headAndNumber2[1];
            
            if (!head1.equals(head2)) {
                return head1.compareTo(head2);
            }
            
            int num1 = Integer.parseInt(number1);
            int num2 = Integer.parseInt(number2);
            
            if (num1 != num2) {
                return Integer.compare(num1, num2);
            }
            
            return 0;
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
        
        return new String[] {head.toUpperCase(), number};
    }
}