class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for(int i=2; i<=n; i++) {  //1로 나누었을 때 항상 나머지는 0이기 때문에 2부터 시작
            if(n % i == 1) {
                answer = i;
                break;
            }
        }
        
        return answer;
    }
}
