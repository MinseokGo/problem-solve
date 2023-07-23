//모의고사
import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        List<Integer> answer = new ArrayList<>();
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2 , 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] cnt = new int[3];
        int max = -1;

        //찍기 방식이 담긴 배열은 크기가 각각 다르므로 마지막 요소에서 인덱스를 초기화해야함
        //초기화 하는 것보다는 %연산을 통해 배열의 길이 이상 인덱스를 넘어가지 않도록함
        for(int i=0; i<answers.length; i++) {
            if(answers[i] == one[i%one.length]) cnt[0]++;
            if(answers[i] == two[i%two.length]) cnt[1]++;
            if(answers[i] == three[i%three.length]) cnt[2]++;
        }

        for(int i=0; i<cnt.length; i++) {
            if(max < cnt[i]) max = cnt[i];
        }
        
        for(int i=0; i<cnt.length; i++) {
            if(max == cnt[i]) answer.add(i+1);
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
