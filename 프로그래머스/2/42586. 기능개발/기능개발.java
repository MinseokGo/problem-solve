import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        int index = 0;
        
        for (int progress : progresses) {
            queue.addLast(progress);
        }
        
        do {
            int count = 1;
            int task = queue.pollFirst();
            int speed = speeds[index];
            int times = (int) Math.ceil(((double) 100 - task) / speed);
            System.out.println(times);
            index++;
            
            while (!queue.isEmpty()) {
                int nextTask = queue.pollFirst();
                int nextSpeed = speeds[index];
                int nextTimes = (int) 
                    Math.ceil(((double) 100 - nextTask) / nextSpeed);
                System.out.println(nextTimes);
                if (times >= nextTimes) {
                    count++;
                    index++;
                } else {
                    queue.addFirst(nextTask);
                    break;
                }
            }
            result.add(count);
        } while (!queue.isEmpty());
        
        return result.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}