import java.util.*;

class Solution {
    
    public int solution(int[] scovilles, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int scovill : scovilles) {
            pq.add(scovill);
        }
        
        while (pq.peek() < K) {
            if (pq.size() == 1) {
                return -1;
            }
            int firstFood = pq.poll();
            int secondFood = pq.poll();
            int newFood = firstFood + secondFood * 2;
            
            pq.add(newFood);
            answer += 1;
        }
        
        return answer;
    }
}
