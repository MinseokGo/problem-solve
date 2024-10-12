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
                
                int cost = calculateCost(current.direction, i, current.cost);
                
                if (isArrivedDestination(nx, ny)) {
                    result = Math.min(result, cost);
                }
                
                if (isShouldUpdateCost(visited, nx, ny, i, cost)) {
                    queue.add(new Position(nx, ny, cost, i));
                    visited[nx][ny][i] = cost;
                }
            }
        }
        
        return result;
    }
    
    private int calculateCost(int prev, int current, int cost) {
        if (prev == -1 || (prev - current) % 2 == 0) {
            return cost + 100;
        }
        return cost + 600;
    }
    
    private boolean isValidPosition(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }
    
    private boolean isArrivedDestination(int x, int y) {
        return x == n - 1 && y == n - 1;
    }
    
    private boolean isShouldUpdateCost(
        int[][][] visited,
        int x,
        int y,
        int direction,
        int cost
    ) {
        return visited[x][y][direction] == 0 || visited[x][y][direction] > cost;
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