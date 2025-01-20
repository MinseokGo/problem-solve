import java.util.*;

class Solution {
    
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> maxQueue 
            = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        
        for (String operation : operations) {
            if (operation.startsWith("I")) {
                maxQueue.add(Integer.parseInt(operation.substring(2)));
                minQueue.add(Integer.parseInt(operation.substring(2)));
            }
            if (operation.startsWith("D")) {
                int flag = Integer.parseInt(operation.substring(2));
                if (flag == 1) {
                    minQueue.remove(maxQueue.poll());
                }
                if (flag == - 1) {
                    maxQueue.remove(minQueue.poll());
                }
            }
        }
        
        if (minQueue.isEmpty() && maxQueue.isEmpty()) {
            return new int[] {0, 0};
        }
        
        return new int[] {maxQueue.poll(), minQueue.poll()};
    }
}