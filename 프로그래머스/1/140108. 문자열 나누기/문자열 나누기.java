import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        char prev = s.charAt(0);
        stack1.push(prev);
        int cnt = 0;
        
        if (s.length() == 1) {
                return 1;
        }
        
        int i = 1;
        while(i != s.length()) {
            if (i == s.length() - 1 && stack1.size() == 0 && stack2.size() == 0) {
                answer++;
                break;
            }
            if (prev == s.charAt(i)) {
                stack1.push(s.charAt(i));
            } else {
                stack2.push(s.charAt(i));
                if (stack1.size() == stack2.size()) {
                    answer++;
                    if (i != s.length() - 1) {
                        prev = s.charAt(i+1);
                    }
                    stack1.clear();
                    stack2.clear();
                }
            }
            
            if (i == s.length() - 1 && (stack1.size() != stack2.size())) {
                answer++;
                break;
            }
            i++;
        }
        
        return answer;
    }
}