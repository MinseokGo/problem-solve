import java.util.*;

//    1
//  2    3
// 4 5  6 7

class Solution {
    public int solution(int n, int a, int b) {
        int answer;

        for (answer = 0; a != b; answer++) {
            a = (a + 1) / 2;
            b = (b + 1) / 2;
        }

        return answer;
    }
}