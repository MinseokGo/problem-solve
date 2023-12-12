class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        int n = board.length;
        boolean[][] safe = new boolean[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    safe[i][j] = true;
                    if (i-1 >= 0) {
                        safe[i-1][j] = true;
                    }
                    if (i+1 <= n-1) {
                        safe[i+1][j] = true;
                    }
                    if (j-1 >= 0) {
                        safe[i][j-1] = true;
                    }
                    if (j+1 <= n-1) {
                        safe[i][j+1] = true;
                    }
                    if (i-1 >= 0 && j-1 >= 0) {
                        safe[i-1][j-1] = true;
                    }
                    if (i+1 <= n-1 && j+1 <= n-1) {
                        safe[i+1][j+1] = true;
                    }
                    if (i+1 <= n-1 && j-1 >= 0) {
                        safe[i+1][j-1] = true;
                    }
                    if (i-1 >= 0 && j+1 <= n-1) {
                        safe[i-1][j+1] = true;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!safe[i][j]) answer++;
            }
        }
        
        return answer;
    }
}