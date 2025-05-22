import java.util.*;

class Solution {
    
    public int[] solution(int[] sequence, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] answer = new int[2];
        answer[1] = Integer.MAX_VALUE;
        
        int sum = 0;
        for (int i = 0; i < sequence.length; i++) {
            int number = sequence[i];
            sum += number;
            deque.addLast(i);
            if (sum > k) {
                while (sum > k) {
                    sum -= sequence[deque.pollFirst()];
                    if (sum == k) {
                        int len = deque.peekLast() - deque.peekFirst();
                        if (len < answer[1] - answer[0]) {
                            answer[0] = deque.peekFirst();
                            answer[1] = deque.peekLast();
                        }
                        break;
                    }
                }
            } else if (sum == k) {
                int len = deque.peekLast() - deque.peekFirst();
                if (len < answer[1] - answer[0]) {
                        answer[0] = deque.peekFirst();
                        answer[1] = deque.peekLast();
                }
            }
        }
        
        return answer;
    }
}
