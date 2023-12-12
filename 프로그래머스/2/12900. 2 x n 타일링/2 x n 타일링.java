class Solution {
    public int solution(int n) {
        int[] ways = new int[n+1];
        ways[0] = 1;
        
        for (int i = 1; i <= n; i++) {
            ways[i] += ways[i-1] % 1000000007;
            if (i >= 2) {
                ways[i] += ways[i-2] % 1000000007;
            }
        }
        
        return ways[n] % 1000000007;
    }
}