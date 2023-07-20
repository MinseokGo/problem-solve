//약수의 개수를 구하고 짝수이면 덧셈 홀수이면 뺄셈
class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for(int i=left; i<=right; i++) {
            if(i % Math.sqrt(i) == 0) { // 16의 경우 제곱수(4)가 있으므로(1,2,4,8,16) 약수 개수는 홀수
                answer -= i;
            } else {
                answer += i;
            }
        }
        
        return answer;
    }
}

//통과는 하지만 시간복잡도가 좋지 않음
// for(int i=left; i<=right; i++) {
//             int cnt = 0;
//             for(int j=1; j<=i; j++) {
//                 if(i % j == 0) {
//                     cnt++;
//                 }
//             }
//             if(cnt % 2 == 0) {
//                 answer += i;
//             } else {
//                 answer -= i;
//             }
//         }
