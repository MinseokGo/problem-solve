import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int left = 0;
        int right = people.length - 1;
        
        Arrays.sort(people);
        
        while(right >= left) {
            if(people[left] + people[right] > limit) {
                right--;
            } else {
                left++;
                right--;
            }
            answer++;
        }
        
        return answer;
    }
}