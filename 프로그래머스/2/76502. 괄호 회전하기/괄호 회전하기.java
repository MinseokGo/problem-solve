import java.util.*;

class Solution {
    
    static Map<Character, Character> couples = new HashMap<>();
    
    private void init() {
        couples.put(')', '(');
        couples.put('}', '{');
        couples.put(']', '[');
    }
    
    public int solution(String s) {
        int answer = 0;
        Stack<Character> brackets = new Stack<>();
        
        init();
        
        for (int i = 0; i < s.length(); i++) {
            char[] chars = replace(s, i).toCharArray();
            boolean isValid = true;
            for (char ch : chars) {
                if (ch == '(' || ch == '{' || ch == '[') {
                    brackets.push(ch);
                }
                else {
                    if (brackets.isEmpty()) {
                        isValid = false;
                        break;
                    } else {
                        char value = couples.get(ch);
                        char pop = brackets.pop();
                        if (pop != value) {
                            brackets.clear();
                            isValid = false;
                            break;
                        }
                    }
                }
            }
            if (!brackets.isEmpty()) {
                isValid = false;
            }
            if (isValid) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private String replace(String brackets, int offset) {
        return brackets.substring(offset, brackets.length())
             + brackets.substring(0, offset);
    }
}