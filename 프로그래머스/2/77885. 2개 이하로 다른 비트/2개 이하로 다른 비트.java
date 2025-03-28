import java.util.*;

class Solution {
    
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for (int i = 0; i<numbers.length; i++) {
            long result = numbers[i];
            String target = Long.toBinaryString(numbers[i]);
            
            if (result % 2 == 0) {
                answer[i] = result + 1;
            } else {
                int index = target.lastIndexOf("0");
                
                if (index == -1) {
                    String tmp = "10" + target.substring(1);
                    answer[i] = Long.parseLong(tmp, 2);
                } else {
                    String tmp = target.substring(0, index) + "10" + target.substring(index + 2);
                    answer[i] = Long.parseLong(tmp, 2);
                }
            }
        }
        return answer;
    }
}
