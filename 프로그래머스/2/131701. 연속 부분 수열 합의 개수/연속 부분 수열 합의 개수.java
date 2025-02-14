import java.util.*;

class Solution {
    
    public int solution(int[] elements) {
        int n = elements.length;
        int[] numbers = new int[n * 2];
        
        for (int i = 0; i < 2 * n; i++) {
            numbers[i] = elements[i % n];
        }
        
        Set<Integer> sums = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            for (int start = 0; start < n; start++) {
                int sum = 0;
                for (int j = 0; j < i; j++) {
                    sum += numbers[start + j];
                }
                sums.add(sum);
            }
        }
        
        return sums.size();
    }
}