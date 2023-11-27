class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        for(int i=1; i<=number; i++) {
            int cnt = 1;
            int half = i/2;
            for(int j=1; j<=half; j++) {
                if(i % j == 0) cnt++;
            }
            if(cnt > limit) cnt = power;
            answer += cnt;
        }
        
        return answer;
    }
}