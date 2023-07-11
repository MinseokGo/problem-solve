import java.util.*;

class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int len = p.length();
        
        for(int i=0; i<t.length()-len+1; i++) {
            String subStr = t.substring(i, i + len);
            if(p.compareTo(subStr) >= 0) answer++;  //p의 값이 같거나 크다면, ++
        }   
        
        return answer;
    }
}

//참고
//compareTo() 메서드는 앞의 값이 더 크면 양수, 같다면 0, 작다면 음수를 리턴함
//p값이 더 크거나 같은 것을 요구하기 때문에 >= 를 이용
