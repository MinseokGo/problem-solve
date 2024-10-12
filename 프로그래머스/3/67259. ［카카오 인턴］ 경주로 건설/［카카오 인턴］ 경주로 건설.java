import java.util.*;

class Solution {
    
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static int n;
    
    public int solution(int[][] board) {
        n = board.length;
        return bfs(board);
    }
    
    private int bfs(int[][] board) {
        int result = Integer.MAX_VALUE;
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(0, 0, 0, -1));
        int[][][] visited = new int[n][n][4];
        
        while (!queue.isEmpty()) {
            Position current = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                if (!isValidPosition(nx, ny) || board[nx][ny] == 1) {
                    continue;
                }
                
                int cost = 100;
                if (current.direction == -1 || (current.direction - i) % 2 == 0) {
                    cost += current.cost;
                } else {
                    cost += current.cost + 500;
                }
                
                if (nx == n - 1 && ny == n - 1) {
                    result = Math.min(result, cost);
                }
                
                if (visited[nx][ny][i] == 0 || visited[nx][ny][i] > cost) {
                    queue.add(new Position(nx, ny, cost, i));
                    visited[nx][ny][i] = cost;
                }
            }
        }
        
        return result;
    }
    
    private boolean isValidPosition(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }
    
    static class Position {
        
        int x;
        int y;
        int cost;
        int direction;
        
        Position(int x, int y, int cost, int direction) {
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.direction = direction;
        }
    }
}