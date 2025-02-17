import java.util.*;

class Solution {
    
    public int solution(int[] arr) {
        return calculateLcm(arr);
    }
    
    private int calculateLcm(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }
        
        int gcd = calculateGcd(arr[0], arr[1]);
        int lcm = (arr[0] * arr[1]) / gcd;
        
        for (int i = 2; i < arr.length; i++) {
            gcd = calculateGcd(lcm, arr[i]);
            lcm = (lcm * arr[i]) / gcd;
        }
        
        return lcm;
    }
    
    private int calculateGcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return calculateGcd(b, a % b);
    }
}