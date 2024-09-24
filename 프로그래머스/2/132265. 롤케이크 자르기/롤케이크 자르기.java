import java.util.*;

class Solution {
    
    public int solution(int[] toppings) {
        int answer = 0;
        
        Map<Integer, Integer> right = new HashMap<>();
        for (int topping : toppings) {
            right.put(topping, right.getOrDefault(topping, 0) + 1);
        }
        
        Set<Integer> left = new HashSet<>();
        for (int topping : toppings) {
            left.add(topping);
            right.put(topping, right.get(topping) - 1);
            if (right.get(topping) == 0) {
                right.remove(topping);
            }
            
            if (left.size() == right.size()) {
                answer++;
            }
        }
        
        return answer;
    }
}
