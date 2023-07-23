import java.util.*;

class Solution {
    boolean solution(String s) {
        int p = 0;
        int y = 0;
        
        s = s.toUpperCase();  //모두 대문자로
        
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == 'P') { p++; }
            else if(s.charAt(i) == 'Y') { y++; }
        }

        return p == y ? true : false;
    }
}
//가독성은 좋은데 효율이 위에꺼보다 별로임
//chars()라는 건 처음 봄
// return s.toUpperCase().chars().filter(i -> i == 'P').count()
//     == s.toUpperCase().chars().filter(i -> i == 'Y').count();
