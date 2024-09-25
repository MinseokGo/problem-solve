import java.util.*;

class Solution {
    
    public int solution(int[] orders) {
        Queue<Integer> belt = new LinkedList<>();
        Stack<Integer> subBelt = new Stack<>();
        int answer = 0;
        
        for (int i = 1; i <= orders.length; i++) {
            belt.add(i);
        }
        
        int i = 0;
        while (i < orders.length) {
            if (!subBelt.isEmpty() && subBelt.peek() == orders[i]) {
                subBelt.pop();
                answer++;
                i++;
            } else if (!belt.isEmpty()) {
                int box = belt.poll();
                if (box == orders[i]) {
                    answer++;
                    i++;
                } else {
                    subBelt.push(box);
                }
            } else {
                break;
            }
        }
        
        return answer;
    }
}
