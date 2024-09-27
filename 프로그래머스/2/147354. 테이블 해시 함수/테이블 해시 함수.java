import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 1;
        
        Arrays.sort(data, (number1, number2) -> {
            if (number1[col - 1] > number2[col - 1]) {
                return 1;
            } else if (number1[col - 1] == number2[col - 1]) {
                return number2[0] - number1[0];
            } else {
                return -1;
            }
        });
        
        for (int i = row_begin - 1; i < row_end; i++) {
            int[] row = data[i];
            int sum = 0;
            for (int j = 0; j < row.length; j++) {
                sum += (row[j] % (i + 1));
            }
            
            if (i == row_begin - 1) {
                answer = sum;
                continue;
            }
            answer ^= sum;
        }
        
        return answer;
    }
}