import java.util.*;

class Solution {
    
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Node> stack = new Stack<>();
        
        stack.push(new Node(0, numbers[0]));
        for (int i = 1; i < numbers.length; i++) {
            if (!stack.isEmpty()) {
                Node node = stack.peek();
                while (!stack.isEmpty() && node.number < numbers[i]) {
                    stack.pop();
                    answer[node.index] = numbers[i];
                    if (!stack.isEmpty()) {
                        node = stack.peek();
                    }
                }
            }
            stack.push(new Node(i, numbers[i]));
        }
        
        for (Node node : stack) {
            answer[node.index] = -1;
        }

        return answer;
    }
    
    static class Node {
        
        int index;
        int number;
        
        Node(int index, int number) {
            this.index = index;
            this.number = number;
        }
    }
}