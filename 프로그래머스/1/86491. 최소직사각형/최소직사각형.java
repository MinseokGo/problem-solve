import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int width = -1;
        int height = -1;
        
        for (int i = 0; i < sizes.length; i++) {
            width = Math.max(width, Math.max(sizes[i][0], sizes[i][1]));
            height = Math.max(height, Math.min(sizes[i][0], sizes[i][1]));
        }
        
        return width * height;
//         List<Integer> width = new ArrayList<>();
//         List<Integer> height = new ArrayList<>();
        
//         for (int i = 0; i < sizes.length; i++) {
//             if (sizes[i][1] > sizes[i][0]) {
//                 int tmp = sizes[i][1];
//                 sizes[i][1] = sizes[i][0];
//                 sizes[i][0] = tmp;
//                 width.add(sizes[i][0]);
//                 height.add(sizes[i][1]);
//             }
//             width.add(sizes[i][0]);
//                 height.add(sizes[i][1]);
//         }
        
//         int maxWidth = width.stream().mapToInt(Integer::intValue).max().getAsInt();
//         int maxHeight = height.stream().mapToInt(Integer::intValue).max().getAsInt();
        
//         return maxWidth * maxHeight;
    }
}