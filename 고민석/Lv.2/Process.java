import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Integer> priority = new LinkedList<>();
        Queue<Integer> index = new LinkedList<>();  //우선순위 값의 위치에 해당하는 인덱스 값. 값과 같이 움직이며 인덱스를 찾는 용도
        
        for(int i=0; i<priorities.length; i++) {
            priority.add(priorities[i]);
            index.add(i);
        }
        int cnt = 1;
        while(!priority.isEmpty()) {
            //큐 내의 최우선순위 찾음
            int max = Collections.max(priority);
            int cur = priority.poll();
            int curIdx = index.poll();

            //현재 뽑아낸 값과 최우선순위가 같고
            if(cur == max) {
                //현재 인덱스와 목표 인덱스가 같다면
                if(curIdx == location) {
                    break;  //while문 탈출 후 실행순위 리턴
                }
                cnt++;
            } else {  //아니라면 큐 맨 뒤로 뽑아낸 값들 넣음
                    priority.add(cur);
                    index.add(curIdx);
            }
        }
        
        return cnt;
    }
}
