import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        List<Integer> answer = new ArrayList<>();
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2 , 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] cnt = new int[3];
        
        int max = -1;
        for(int i=0; i<answers.length; i++) {
            if(answers[i] == one[i%one.length]) cnt[0]++;
            if(answers[i] == two[i%two.length]) cnt[1]++;
            if(answers[i] == three[i%three.length]) cnt[2]++;
        }
        for(int i=0; i<cnt.length; i++) {
            if(max < cnt[i]) max = cnt[i];
        }
        
        for(int i=0; i<3; i++) {
            if(max == cnt[i]) answer.add(i+1);
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}