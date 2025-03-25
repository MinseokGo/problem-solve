import java.util.*;

class Solution {
    
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int work : works) {
            pq.add(work);
        }
        
        while (n > 0) {
            int work = pq.poll();
            if (work > 0) {
                work -= 1;
            }
            pq.add(work);
            n--;
        }
        
        while (pq.size() > 0) {
            answer += Math.pow(pq.poll(), 2);
        }
        
        return answer;
    }
}