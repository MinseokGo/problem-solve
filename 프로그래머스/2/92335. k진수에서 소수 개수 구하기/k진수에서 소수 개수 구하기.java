import java.util.*;

class Solution {
    
    public int solution(int n, int k) {
        int answer = 0;
        
        String[] numbers = Integer.toString(n, k).split("0");
        for (String str : numbers) {
            if (str.length() == 0) {
                continue;
            }
            
            long number = Long.parseLong(str, 10);
            boolean isPrime = true;
            if (number != 1) {
                for (int i = 2; i <= Math.sqrt(number); i++) {
                    if (number % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
            } else {
                continue;
            }
            
            if (isPrime) {
                answer += 1;
            }
        }
        
        return answer;
    }
}