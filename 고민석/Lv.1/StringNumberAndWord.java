import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        String[] numbers = {"zero", "one", "two", "three", "four", 
                            "five", "six", "seven", "eight", "nine"};
        
        int i = 0;
        for(String str : numbers) {
            s = s.replaceAll(str, String.valueOf(i));  //정규표현식(str)이 문자열 내에 있으면 모두 i로 치환
            i++;
        }
        
        answer = Integer.parseInt(s);
        
        return answer;
    }
}
