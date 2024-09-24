import java.util.*;

class Solution {
    
    public int solution(int[] toppings) {
        int answer = 0;
        
        Set<Integer> left = new HashSet<>();
        
        Map<Integer, Integer> rightCount = new HashMap<>();
        for (int topping : toppings) {
            rightCount.put(topping, rightCount.getOrDefault(topping, 0) + 1);
        }
        
        for (int i = 0; i < toppings.length - 1; i++) {
            left.add(toppings[i]);
            
            rightCount.put(toppings[i], rightCount.get(toppings[i]) - 1);
            if (rightCount.get(toppings[i]) == 0) {
                rightCount.remove(toppings[i]);
            }
            
            if (left.size() == rightCount.size()) {
                answer++;
            }
        }
        
        return answer;
    }
}
