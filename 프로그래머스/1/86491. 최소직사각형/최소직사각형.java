import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        List<Integer> width = new ArrayList<>();
        List<Integer> height = new ArrayList<>();
        
        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][1] > sizes[i][0]) {
                int tmp = sizes[i][1];
                sizes[i][1] = sizes[i][0];
                sizes[i][0] = tmp;
                width.add(sizes[i][0]);
                height.add(sizes[i][1]);
            }
            width.add(sizes[i][0]);
                height.add(sizes[i][1]);
        }
        
        int maxWidth = width.stream().mapToInt(Integer::intValue).max().getAsInt();
        int maxHeight = height.stream().mapToInt(Integer::intValue).max().getAsInt();
        
        return maxWidth * maxHeight;
    }
}