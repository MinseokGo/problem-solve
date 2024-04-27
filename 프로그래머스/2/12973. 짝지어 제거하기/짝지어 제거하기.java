import java.util.*;

class Solution {
    public int solution(String s) {
       Stack<Character> stack = new Stack<>();
        
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            if (stack.isEmpty()) {
                stack.push(ch);
                continue;
            }
            if (ch == stack.peek()) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        if (stack.isEmpty()) return 1;
        
        return 0;
    }
}