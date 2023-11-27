import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Integer> priority = new LinkedList<>();
        Queue<Integer> index = new LinkedList<>();
        
        for(int i=0; i<priorities.length; i++) {
            priority.add(priorities[i]);
            index.add(i);
        }
        int cnt = 1;
        while(!priority.isEmpty()) {
            int max = Collections.max(priority);
            int cur = priority.poll();
            int curIdx = index.poll();
            
            if(cur == max) {
                if(curIdx == location) {
                    break;
                }
                cnt++;
            } else {
                    priority.add(cur);
                    index.add(curIdx);
            }
        }
        
        return cnt;
    }
}