import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = n+1;
        
        while(true) {
            int nLen = Integer.bitCount(n);
            int aLen = Integer.bitCount(answer);
            if(nLen == aLen) break;
            answer++;
        }
        
        return answer;
    }
}

//n이 100만이라 2중 반복문 안됨
//Interger.toBinaryString(str)해서 replaceAll을 통해 1을 공백으로 제거하고 길이 비교했는데
//replaceAll 때문에 시간초과뜸 -> 2중 반복
//while(true) {
//  String s1 = Integer.toBinaryString(n);
//  String s2 = Integer.toBinaryString(answer);
//  int nLen = s1.length() - s1.replaceAll("1", "");
//  int aLen = s2.length() - s2.replaceAll("1", "");
//  if(nLen == aLen) break;
//  answer++;
//-> 시간초과
//  1 개수 카운트 하는 로직을 고차함수로 바꿔봤음
//  long nLen = s1.chars().filter(c -> c == '1').count();
//  long aLen = s2.chars().filter(c -> c == '1').count();
//-> 시간초과
