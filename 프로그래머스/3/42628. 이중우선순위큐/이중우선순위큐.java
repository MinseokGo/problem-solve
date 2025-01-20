import java.util.*;

class Solution {
    
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> numbers = new PriorityQueue<>();
        
        for (String operation : operations) {
            if (operation.startsWith("I")) {
                numbers.add(Integer.parseInt(operation.substring(2)));
            }
            if (operation.startsWith("D")) {
                int flag = Integer.parseInt(operation.substring(2));
                if (!numbers.isEmpty() && flag == 1) {
                    Integer maxValue = numbers.stream()
                        .max(Integer::compare)
                        .orElse(null);
                    
                    numbers.remove(maxValue);
                }
                if (!numbers.isEmpty() && flag == -1) {
                    numbers.poll();
                }
            }
        }
        
        if (numbers.isEmpty()) {
            return new int[] {0, 0};
        }
        
        if (numbers.size() == 1) {
            int number = numbers.poll();
            return new int[] {number, number};
        }
        
        int maxValue = numbers.stream()
            .max(Integer::compare)
            .orElse(null);
        
        return new int[] {maxValue, numbers.poll()};
    }
}