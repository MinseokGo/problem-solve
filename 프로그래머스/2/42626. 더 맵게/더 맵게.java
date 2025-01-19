import java.util.*;

class Solution {
    
    public int solution(int[] scovilles, int K) {
        int answer = 0;
        PriorityQueue<Integer> foods = new PriorityQueue<>();
    
        for (int scoville : scovilles) {
            foods.add(scoville);
        }
        
        while (!foods.isEmpty()) {
            int firstFood = foods.poll();
            if (foods.isEmpty()) {
                if (firstFood < K) {
                    answer = -1;
                    break;
                }
            }
            
            if (firstFood >= K) {
                foods.add(firstFood);
                break;
            }
            
            if (foods.isEmpty()) {
                break;
            }
            
            int secondFood = foods.poll();
            
            answer += 1;
            int newFood = firstFood + secondFood * 2;
            foods.add(newFood);
        }
        
        return answer;
    }
}