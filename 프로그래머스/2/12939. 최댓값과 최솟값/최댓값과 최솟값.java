import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] str = s.split("\\s");
        int[] arr = new int[str.length];
        
        for(int i=0; i<arr.length; i++) arr[i] = Integer.parseInt(str[i]);
        
        int max = arr[0];
        int min = arr[0];
        
        for(int i=1; i<arr.length; i++) {
            max = Math.max(arr[i], max);
            min = Math.min(arr[i], min);
        }
        
        answer = min + " " + max;
        
        return answer;
    }
}