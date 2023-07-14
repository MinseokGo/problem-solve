class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        while(true) {
            if(n >= a) {  //빈병을 바꿀수 있으면
                answer += (n/a)*b;
                n = (n/a)*b + (n%a);
            } else {  //없으면 반복문 탈출
                break;
            }
        }
        
        return answer;
    }
}
