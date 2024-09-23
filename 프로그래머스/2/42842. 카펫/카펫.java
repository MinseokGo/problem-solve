class Solution {
    
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        
        int area = brown + yellow;
        int width;
        int height = 3;
        
        while (true) {
            if (area % height != 0) {
                height++;
                continue;
            }
            
            width = area / height;
            if ((width - 2) * (height - 2) == yellow) {
                return new int[] {width, height};
            }
            height++;
        }
    }
}