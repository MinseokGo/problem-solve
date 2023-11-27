import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int select = nums.length/2;
        HashMap<String, Boolean> map = new  HashMap<>();
        
        for(int i : nums) map.put(String.valueOf(i), true);
        
        if(map.size() > select) return select;
        else answer = map.size();
        
        return answer;
    }
}