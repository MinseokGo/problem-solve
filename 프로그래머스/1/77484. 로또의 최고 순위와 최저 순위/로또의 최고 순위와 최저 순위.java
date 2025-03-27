import java.util.*;

class Solution {
    
    public int[] solution(int[] lottos, int[] win_nums) {
        Set<Integer> userNumbers = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        int correct = 0;
        int zero = 0;
        
        for (int number : lottos) {
            if (number == 0) {
                zero += 1;
                continue;
            }
            userNumbers.add(number);
        }
        
        for (int number : win_nums) {
            queue.add(number);
        }

        while (!queue.isEmpty()) {
            int winNumber = queue.poll();
            if (userNumbers.contains(winNumber)) {
                correct += 1;
            }
        }
        
        int maxRank = calculateRank(correct + zero);
        int minRank = calculateRank(correct);
        
        return new int[] {maxRank, minRank};
    }
    
    private int calculateRank(int count) {
        int rank = 6 - count + 1;
        if (rank >= 6) {
            return 6;
        } else {
            return rank;
        }
    }
}