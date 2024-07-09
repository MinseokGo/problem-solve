import java.util.*;

class Solution {
    
    final int[] nx = {-1, 1, 0, 0};
    final int[] ny = {0, 0, -1, 1};
    static int n;
    static int m;
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        
        return bfs(new Position(0, 0, 1), maps);
    }
    
    private int bfs(Position position, int[][] maps) {
        Queue<Position> queue = new LinkedList<>();
        queue.add(position);
        maps[position.x][position.y] = 0;
        
        while (!queue.isEmpty()) {
            Position present = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int dx = present.x + nx[i];
                int dy = present.y + ny[i];
                
                if (dx == n - 1 && dy == m - 1) {
                    return present.count + 1;
                }
                
                if (!isValidPosition(dx, dy) && maps[dx][dy] != 0) {
                    queue.add(new Position(dx, dy, present.count + 1));
                    maps[dx][dy] = 0;
                }
            }
        }
        
        return -1;
    }
    
    private boolean isValidPosition(int x, int y) {
        return (x < 0 || x >= n || y < 0 || y >= m);
    }
    
    static class Position {
        int x;
        int y;
        int count;
        
        public Position(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}