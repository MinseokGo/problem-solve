import java.util.*;

class Solution {
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n;
    static int m;
    
    public int solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        int[] start = findPosition(maps, 'S');
        int[] lever = findPosition(maps, 'L');
        int[] exit = findPosition(maps, 'E');

        int distanceToLever = bfs(maps, start, lever);
        if (distanceToLever == -1) return -1;

        int distanceToExit = bfs(maps, lever, exit);
        if (distanceToExit == -1) return -1;

        return distanceToLever + distanceToExit;
    }
    
    private int bfs(String[] maps, int[] start, int[] end) {
        Queue<Position> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        queue.add(new Position(start[0], start[1], 0));
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            Position pos = queue.poll();
            if (pos.x == end[0] && pos.y == end[1]) {
                return pos.count;
            }
            for (int i = 0; i < 4; i++) {
                int nx = pos.x + dx[i];
                int ny = pos.y + dy[i];
                if (isValidPosition(nx, ny) && !visited[nx][ny]) {
                    char cell = maps[nx].charAt(ny);
                    if (cell != 'X') {
                        visited[nx][ny] = true;
                        queue.add(new Position(nx, ny, pos.count + 1));
                    }
                }
            }
        }
        return -1;
    }
    
    private int[] findPosition(String[] maps, char target) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maps[i].charAt(j) == target) {
                    return new int[] {i, j};
                }
            }
        }
        return null;
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
