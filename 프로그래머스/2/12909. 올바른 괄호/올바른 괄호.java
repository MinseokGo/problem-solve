import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> brackets = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char bracket = s.charAt(i);
            if (bracket == '(') {
                brackets.push(bracket);
            }
            if (bracket == ')') {
                if (brackets.size() > 0) {
                    brackets.pop();
                } else {
                    return false;
                }
                
            }
        }
        
        if (brackets.size() > 0) {
            return false;
        }
        
        return true;
    }
}