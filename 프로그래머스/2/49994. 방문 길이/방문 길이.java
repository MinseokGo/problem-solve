import java.util.*;

class Solution {
    public int solution(String dirs) {
        Map<Character, int[]> location = new HashMap<>();
        location.put('U', new int[] {0, 1});
        location.put('D', new int[] {0, -1});
        location.put('R', new int[] {1, 0});
        location.put('L', new int[] {-1, 0});
        
        int x = 5;
        int y = 5;
        int nx, ny;
        
        char[] chars = dirs.toCharArray();
        Set<String> answer = new HashSet<>();
        for (char ch : chars) {
            int[] move = location.get(ch);
            nx = x + move[0];
            ny = y + move[1];
            if (nx > 10 || ny > 10 || nx < 0 || ny < 0) {
                continue;
            }
            answer.add(x + " " + y + " " + nx + " " + ny);
            answer.add(nx + " " + ny + " " + x + " " + y);
            
            x = nx;
            y = ny;
        }
        
        return answer.size() / 2;
    }
}