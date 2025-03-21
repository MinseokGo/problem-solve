import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String str = Integer.toString(n, k) + "0";
        Queue<String> queue = new LinkedList<>();
        
        int index = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                String sub = str.substring(index, i);
                if (sub.length() != 0) {
                    queue.add(sub);
                }
                index = i + 1;                
            }
        }
        
        while (!queue.isEmpty()) {
            String sub = queue.poll();
            if (!sub.equals("1")) {
                long number = Long.parseLong(sub, 10);
                
                boolean isPrime = true;
                for (int i = 2; i <= Math.pow(number, 0.5); i++) {
                    if (number % i == 0) {
                        isPrime = false;
                    }
                }
            
                if (isPrime) {
                    answer += 1;
                }
            }
        }
        
        return answer;
    }
}