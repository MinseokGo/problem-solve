import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        int[] arr = new int[progresses.length];
        int j=0;
        
        for(int i : progresses) {
            if((100-i) % speeds[j] == 0) {
                arr[j] = (100-i) / speeds[j];
            } else {
                arr[j] = (100-i) / speeds[j];
                arr[j]++;
            }
            j++;
        }
        int cnt = 1;
        int pilotNum = arr[0];
        for(int i=1; i<arr.length; i++) {
            if(pilotNum >= arr[i]) {
                cnt++;
            } else {
                answer.add(cnt);
                pilotNum = arr[i];
                cnt = 1;
            }
        }
        answer.add(cnt);
        
        return answer.stream().mapToInt(x->x).toArray();
    }
}