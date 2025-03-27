import java.util.*;

class Solution {
    
    public int[] solution(int[] lottos, int[] win_nums) {
        Map<Integer, Integer> userNumbers = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        int correct = 0;
        int zero = 0;
        
        for (int number : lottos) {
            if (number == 0) {
                zero += 1;
                continue;
            }
            userNumbers.put(number, userNumbers.getOrDefault(number, 0) + 1);
        }
        
        for (int number : win_nums) {
            queue.add(number);
        }

        int usedZero = 0;
        while (!queue.isEmpty()) {
            int winNumber = queue.poll();
            
            if (userNumbers.containsKey(winNumber)) {
                correct += 1;
            } else {
                if (zero > usedZero) {
                    correct += 1;
                    usedZero += 1;
                }
            }
        }
        
        int maxRank = calculateRank(correct);
        int minRank = calculateRank(correct - zero);
        System.out.println(correct);
        System.out.println(zero);
        
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