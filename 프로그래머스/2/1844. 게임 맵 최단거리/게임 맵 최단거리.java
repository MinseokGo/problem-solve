import java.util.*;

class Solution {
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n;
    static int m;
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        return bfs(maps, 1);
    }
    
    private int bfs(int[][] maps, int count) {
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(0, 0, count));
        maps[0][0] = 0;
        
        while (!queue.isEmpty()) {
            Position position = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = position.x + dx[i];
                int ny = position.y + dy[i];
                if (nx == n - 1 && ny == m - 1) {
                    return position.count + 1;
                }
                if (isValidPosition(nx, ny) && maps[nx][ny] == 1) {
                    queue.add(new Position(nx, ny, position.count + 1));
                    maps[nx][ny] = 0;
                }
            }
        }
        return -1;
    }
    
    private boolean isValidPosition(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < m;
    }
    
    static class Position {
        
        int x;
        int y;
        int count;
        
        Position(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}