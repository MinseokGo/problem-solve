class Solution {
    
    public int solution(int storey) {
        int answer = 0;
        
        while (storey > 0) {
            int mod = storey % 10;
            int next = storey % 100 / 10;

            if (mod >= 6 || mod == 5 && next >= 5) {
                storey += 10 - mod;
                answer += 10 - mod;
            } else if (mod >= 5 && next >= 5) {
                storey += 5;
                answer += 5;
            } else {
                answer += mod;
            }
            
            storey /= 10;
        }
        
        return answer;
    }
}
