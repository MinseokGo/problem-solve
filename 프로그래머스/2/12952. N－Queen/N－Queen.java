class Solution {
    
    public int solution(int n) {    
        boolean[] width = new boolean[n];
        boolean[] diagonal1 = new boolean[n * 2];
        boolean[] diagonal2 = new boolean[n * 2];
        return findNQueen(0, n, width, diagonal1, diagonal2);
    }
    
    private int findNQueen(
        int x, int n, boolean[] width, boolean[] diagonal1, boolean[] diagonal2
    ) {
        int result = 0;
        if (x == n) {
            result++;
        } else {
            for (int i = 0; i < n; i++) {
                if (width[i] || diagonal1[i + x] || diagonal2[i - x + n]) {
                    continue;
                }
                
                width[i] = diagonal1[i + x] = diagonal2[i - x + n] = true;
                result += findNQueen(x + 1, n, width, diagonal1, diagonal2);
                width[i] = diagonal1[i + x] = diagonal2[i - x + n] = false;
            }
        }
        return result;
    }
}