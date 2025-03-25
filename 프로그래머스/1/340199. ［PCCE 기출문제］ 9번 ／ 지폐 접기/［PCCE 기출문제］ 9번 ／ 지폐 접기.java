class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        int width = wallet[0];
        int height = wallet[1];
        
        while (true) {
            int billWidth = bill[0];
            int billHeight = bill[1];
            if (width >= billWidth && height >= billHeight) {
                break;
            } else if (width >= billHeight && height >= billWidth) {
                break;
            }
            
            if (billWidth >= billHeight) {
                bill[0] /= 2;
            } else {
                bill[1] /= 2;
            }
            
            answer++;
        }
        
        return answer;
    }
}