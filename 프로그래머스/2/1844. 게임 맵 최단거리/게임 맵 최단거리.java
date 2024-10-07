import java.util.*;

class Solution {
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public int solution(int[][] maps) {
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        return bfs(maps, visited, 1);
    }
    
    private int bfs(int[][] maps, boolean[][] visited, int count) {
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(0, 0, count));
        visited[0][0] = true;
        
        while (!queue.isEmpty()) {
            Position position = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = position.x + dx[i];
                int ny = position.y + dy[i];
                if (nx == maps.length - 1 && ny == maps[0].length - 1) {
                    return position.count + 1;
                }
                if (isValidPosition(nx, ny, maps) && !visited[nx][ny]) {
                    if (maps[nx][ny] == 1) {
                        queue.add(new Position(nx, ny, position.count + 1));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        return -1;
    }
    
    private boolean isValidPosition(int x, int y, int[][] maps) {
        return x >= 0 && y >= 0 && x < maps.length && y < maps[0].length;
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