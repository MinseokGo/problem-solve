class Solution {
    
    private int[] count = new int[2];
    
    public int[] solution(int[][] arr) {
        int height = arr.length;
        int width = arr[0].length;
        dfs(arr, 0, height, 0, width, height * width);
        return count;
    }
    
    private void dfs(int[][] map, int x1, int x2, int y1, int y2, int size) {
        if (size == 0) {
            return;
        }
        
        int sum = 0;
        for (int i = x1; i < x2; i++) {
            for (int j = y1; j < y2; j++) {
                sum += map[i][j];
            }
        }
        
        if (sum == size) {
            count[1] += 1;
            return;
        } else if (sum == 0) {
            count[0] += 1;
            return;
        }
        
        int midX = (x1 + x2) / 2;
        int midY = (y1 + y2) / 2;
        dfs(map, x1, midX, y1, midY, size / 4); // 왼쪽 위
        dfs(map, x1, midX, midY, y2, size / 4); // 오른쪽 위
        dfs(map, midX, x2, y1, midY, size / 4); // 왼쪽 아래
        dfs(map, midX, x2, midY, y2, size / 4); // 오른쪽 아래
    }
}
