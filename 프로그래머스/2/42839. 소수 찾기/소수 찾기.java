import java.util.*;

class Solution {
    
    static int answer = 0;
    static Set<Integer> numbers = new HashSet<>();
    
    public int solution(String input) {
        boolean[] visited = new boolean[input.length()];
        dfs("", input, visited);
        return answer;
    }
    
    private void dfs(
        String current,
        String input,
        boolean[] visited
    ) {
        if (!current.equals("")) {
            int number = Integer.parseInt(current);
            boolean isPrime = true;
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (number > 1 && numbers.add(number) && isPrime) {
                // System.out.println(number);
                answer++;
            }
        }
        
        for (int i = 0; i < input.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(current + input.charAt(i), input, visited);
                visited[i] = false;
            }
        }
    }
}