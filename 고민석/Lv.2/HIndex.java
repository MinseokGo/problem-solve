import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
       
        for(int i=0; i<citations.length; i++) {
            int h = citations.length - i;

            //citations[i] 값을 기준으로
            //이 값보다 뒤에 남은 논문의 수(h)가 같아지게 되면(또는 작다면) H-Index 리턴
            if(citations[i] >= h) {
                answer = h;
                break;
            }
        }
        
        return answer;
    }
}
