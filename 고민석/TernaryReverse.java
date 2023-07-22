//3진법 뒤집기
import java.util.*;

class Solution {
    public int solution(int n) {
        String str = "";
        int answer = 0;

        //3진법 변환
        while(n > 0) {
            str += n%3;
            n /= 3;
        }  //0021

        //역순으로 맨뒷자리부터 10진수로 변환
        //1200 -> 7
        //여기부터
        str = new StringBuilder(str).reverse().toString();
        int k = 1;
        
        for(int i=0; i<str.length(); i++) {
            answer += Character.getNumericValue(str.charAt(i)) * k;
            k *= 3;
        }
        //여기까지 제외하고
        //return Integer.parseInt(str); 해도됨
        return answer;
    }
}
