import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();
        int sum = 0;
        int time = 0;
        
        for(int i : truck_weights) {
            while(true) {
                if(queue.isEmpty()) {
                    queue.offer(i);
                    sum += i;
                    time++;
                    break;
                } else if(queue.size() == bridge_length) {
                        sum -= queue.poll();
                } else {
                    if((sum + i) > weight) {
                        queue.offer(0);
                        time++;
                    } else {
                        queue.offer(i);
                        sum += i;
                        time++;
                        break;
                    }
                }
            }
        }
        return time + bridge_length;
    }
}