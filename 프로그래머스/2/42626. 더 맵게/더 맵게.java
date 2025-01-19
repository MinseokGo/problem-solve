import java.util.*;

class Solution {
    
    public int solution(int[] scovilles, int K) {
        int answer = 0;
        PriorityQueue<Integer> foods = new PriorityQueue<>();
    
        for (int scoville : scovilles) {
            foods.add(scoville);
        }
        
        while (foods.size() > 1) {
            if (foods.peek() >= K) {
                return answer;
            }
            
            int firstFood = foods.poll();
            int secondFood = foods.poll();
            int newFood = firstFood + secondFood * 2;
            foods.add(newFood);
            answer++;
        }
        
        return foods.peek() >= K ? answer : -1;
    }
}