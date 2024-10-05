import java.util.*;

class Solution {
    
    static int answer = Integer.MAX_VALUE;
    
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        // int answer = dfs(words, begin, target, visited, 0);
        int answer = bfs(words, begin, target, visited);
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
    
    private int dfs(String[] words, String current, String target, boolean[] visited, int count) {
        if (current.equals(target)) {
            return count;
        }
        
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (!visited[i] && isChangedOneSpell(current, words[i])) {
                visited[i] = true;
                min = Math.min(min, dfs(words, words[i], target, visited, count + 1));
                visited[i] = false;
            }
        }
        return min;
    }
    
    private int bfs(String[] words, String begin, String target, boolean[] visited) {
        int answer = Integer.MAX_VALUE;
        Queue<Current> queue = new LinkedList<>();
        queue.add(new Current(begin, 0));
        
        while (!queue.isEmpty()) {
            Current cur = queue.poll();
            if (cur.word.equals(target)) {
                answer = cur.count;
                return answer;
            }
            
            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && isChangedOneSpell(cur.word, words[i])) {
                    visited[i] = true;
                    queue.add(new Current(words[i], cur.count + 1));
                }
            }
        }
        return answer;
    }
    
    private boolean isChangedOneSpell(String str, String target) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == target.charAt(i)) {
                count++;
            }
        }
        return count == str.length() - 1;
    }
    
    static class Current {
        
        String word;
        int count;
        
        Current(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
}