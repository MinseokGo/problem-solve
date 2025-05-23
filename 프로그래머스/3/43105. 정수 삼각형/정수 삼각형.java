import java.util.Arrays;

class Solution {
    
    public int solution(int[][] triangle) {
        int answer = Integer.MIN_VALUE;
        
        for (int i = 1; i < triangle.length; i++) {
            triangle[i][0] += triangle[i - 1][0];
            triangle[i][i] += triangle[i - 1][i - 1];
            
            for (int j = 1; j < i; j++) {
                triangle[i][j] += Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]);
            }
        }
        
        return Arrays.stream(triangle[triangle.length - 1])
                    .max()
                    .getAsInt();
    }
}
