class Solution {
    public long solution(int n) {
        int[] ways = new int[n+1];
        ways[0] = 1; // 합이 0인 경우의 수는 1
        
        for (int i = 1; i <= n; i++) {
            ways[i] += ways[i-1] % 1234567;
            if (i >= 2) {
                ways[i] += ways[i-2] % 1234567;
            }
        }
        
        return ways[n] % 1234567;
    }
}