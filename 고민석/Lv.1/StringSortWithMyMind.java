import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = {};
        
        Arrays.sort(strings, (s1, s2) -> 
                    {
                        if(s1.charAt(n) > s2.charAt(n)) {
                            return 1;
                        } else if(s1.charAt(n) == s2.charAt(n)) {  //해당 문자가 같은 경우 문자열 자체를 비교
                            return s1.compareTo(s2);
                        } else {
                            return -1;
                        }
                    });
        
        return strings;
    }
}
