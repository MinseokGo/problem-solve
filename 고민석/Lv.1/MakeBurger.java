import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        Stack<Integer> stack = new Stack<>();
        int answer = 0;

        for(int i : ingredient) {
            stack.push(i);
            if(stack.size() >= 4) {  스택에 4개 이상 쌓였을 떄
                //위에서부터 4개가 1231이면(햄,야채,고기,빵) 개수 증가, 4개 스택에서 제거
                if(stack.get(stack.size() -4) == 1
                && stack.get(stack.size() -3) == 2
                && stack.get(stack.size() -2) == 3
                && stack.get(stack.size() -1) == 1) {
                    answer++;
                    stack.pop(); stack.pop(); stack.pop(); stack.pop();
                }
            }
        }
        
        return answer;
    }
}
//         시간 초과 뜸
//         int answer = 0;
//         String str = "";
        
//         for(int i : ingredient) {
//             str += String.valueOf(i);
//             if(str.length() >= 4) {
//                 if(str.contains("1231")) {
//                     str = str.replace("1231", "");
//                     answer++;
//                 }
//             }
//         }  
