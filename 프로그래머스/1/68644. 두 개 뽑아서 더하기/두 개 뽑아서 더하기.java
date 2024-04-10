import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        TreeSet<Integer> sumNumbers = new TreeSet<>();
        
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                final int sumNumber = numbers[i] + numbers[j];
                sumNumbers.add(sumNumber);
            }
        }
        
        int[] result = new int[sumNumbers.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = sumNumbers.pollFirst();
        }
        
        return result;
    }
}