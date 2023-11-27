class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int n = board.length;
        
        if (h-1 >= 0) {
            if (board[h][w].equals(board[h-1][w])) {
                answer++;
            }
        }
        if (h+1 <= n-1) {
            if (board[h][w].equals(board[h+1][w])) {
                answer++;
            }
        }
        if (w-1 >= 0) {
            if (board[h][w].equals(board[h][w-1])) {
                answer++;
            }
        }
        if (w+1 <= n-1) {
            if (board[h][w].equals(board[h][w+1])) {
                answer++;
            }
        }
        
        return answer;
    }
}