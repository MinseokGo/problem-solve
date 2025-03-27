import java.util.*;

class Solution {
    
    public int solution(String dartResult) {
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        
        List<String> strs = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (char ch : dartResult.toCharArray()) {
            if (Character.isDigit(ch)) {
                sb.append(ch);
            } else {
                if (sb.length() > 0) {
                    strs.add(sb.toString());
                    sb.setLength(0);
                }
                strs.add(String.valueOf(ch));
            }
        }
        
        for (String str : strs) {
            System.out.println(str);
            int number = -1;
            char ch = 'x';
            try {
                number = Integer.parseInt(str);
            } catch (NumberFormatException exception) {
                ch = str.charAt(0);
            }
            
            if (number >= 0) {
                stack.push(number);
            } else if (Character.isLetter(ch)) {
                int score = stack.pop();
                stack.push(calculateMutipleScore(score, ch));
            } else {
                if (ch == '*') {
                    if (stack.size() >= 2) {
                        int current = stack.pop() * 2;
                        int prev = stack.pop() * 2;
                        stack.push(prev);
                        stack.push(current);
                    } else if (stack.size() == 1) {
                        int current = stack.pop() * 2;
                        stack.push(current);
                    }
                } else if (ch == '#') {
                    int current = stack.pop() * -1;
                    stack.push(current);
                }
            }
        }
        
        for (int score : stack) {
            answer += score;
        }
        
        return answer;
    }
    
    private int calculateMutipleScore(int score, char ch) {
        if (ch == 'D') {
            return (int) Math.pow(score, 2);
        }
        if (ch == 'T') {
            return (int) Math.pow(score, 3);
        }
        return score;
    }
}