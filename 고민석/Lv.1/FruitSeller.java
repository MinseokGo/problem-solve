import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        int len = 0;
      
        Integer[] newArray = Arrays.stream(score)
                                    .boxed()
                                    .toArray(Integer[]::new);

        //내림차순 정렬
        Arrays.sort(newArray, Collections.reverseOrder());
        score = Arrays.stream(newArray)
                       .mapToInt(Integer::intValue)
                       .toArray();
        
        len = (score.length / m) * m ;

        //배열 복사 후 마지막 인덱스 값에 장바구니에 담기는 과일 수 곱해서 덧셈
        for(int i=0; i<len; i+=m ) {
            int arr[] = Arrays.copyOfRange(score, i, m+i);
            answer += arr[m-1] * m;
        }
    
        return answer;
    }
}
