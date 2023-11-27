import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        String[] numbers = {"zero", "one", "two", "three", "four", 
                            "five", "six", "seven", "eight", "nine"};
        
        int i = 0;
        for(String str : numbers) {
            s = s.replaceAll(str, String.valueOf(i));
            i++;
        }
        
        answer = Integer.parseInt(s);
        
        return answer;
    }
}