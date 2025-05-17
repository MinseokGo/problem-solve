class Solution {
    
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int size = 2 * w + 1;

        int prev = 1;
        for (int station : stations) {
            int region = station - w - prev;
            if (region > 0) {
                answer += (region + size - 1) / size;
            }
            prev = station + w + 1;
        }

        if (prev <= n) {
            int region = n - prev + 1;
            answer += (region + size - 1) / size;
        }

        return answer;
    }
}
