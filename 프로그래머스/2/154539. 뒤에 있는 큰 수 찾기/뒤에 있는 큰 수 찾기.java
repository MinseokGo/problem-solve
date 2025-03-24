import java.util.*;

class Solution {
    
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();
        
        Arrays.fill(answer, -1);
        stack.push(0);
        
        for (int i = 1; i < numbers.length; i++) {
            while (stack.size() > 0 && numbers[stack.peek()] < numbers[i]) {
                int index = stack.pop();
                answer[index] = numbers[i];
            }
            stack.push(i);
        }
        
        return answer;
    }
}