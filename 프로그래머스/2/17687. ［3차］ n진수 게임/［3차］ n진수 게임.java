import java.util.*;

class Solution {
    
    public String solution(int n, int t, int m, int p) {
        StringBuilder total = new StringBuilder();
        int num = 0;
        while (total.length() < t * m) {
            total.append(
                Integer.toString(num++, n)
                    .toUpperCase()
            );
        }
        
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < t; i++) {
            result.append(total.charAt(i * m + (p - 1)));
        }
        
        return result.toString();
    }
}