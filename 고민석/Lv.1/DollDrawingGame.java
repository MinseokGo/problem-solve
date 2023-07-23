//크레인 인형뽑기 게임

import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        
        for(int move : moves) {
            for(int i=0; i<board[move - 1].length; i++) {
                if(board[i][move - 1] != 0) {  //해당 자리에 인형이 있으면
                    stack.push(board[i][move - 1]);
                    board[i][move - 1] = 0;  //스택에 넣고 0으로 처리해 인형이 없는 것으로 처리
                    break;  //인형을 하나 넣었으므로 다음 반복으로 이동
                }
            }
            if(stack.size() >= 2) {  //스택에 쌓인 인형이 2개 이상일때만
                if(stack.get(stack.size() - 2) == stack.get(stack.size() - 1)) {   //위에서 2개의 인형이 같으면 제거하고 터트린 인형 2개 추가
                    stack.pop();
                    stack.pop();
                    answer += 2;
                }
            }
        }
        
        return answer;
    }
}
