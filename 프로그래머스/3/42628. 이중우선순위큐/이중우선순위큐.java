import java.util.*;

class Solution {
    
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for (String operation : operations) {
            if (operation.startsWith("I")) {
                int number = Integer.parseInt(operation.substring(2));
                minHeap.add(number);
                maxHeap.add(number);
            } else {
                if (operation.equals("D 1") && !minHeap.isEmpty()) {
                    minHeap.remove(maxHeap.poll());
                } else {
                    maxHeap.remove(minHeap.poll());
                }
            }
        }
        
        if (minHeap.isEmpty() && maxHeap.isEmpty()) {
            return new int[] {0, 0};
        }
        
        return new int[] {maxHeap.poll(), minHeap.poll()};
    }
}