import java.util.*;

//큐보다 배열로 이중 반복하는게 정확성, 효율성에서 더 좋은 결과를 보임

class Solution {
    public int[] solution(int[] prices) {
        List<Integer> answer = new ArrayList<>();

        for(int i=0; i<prices.length; i++) {
              int cnt = 0;
              for(int j=i+1; j<prices.length; j++) {
                  cnt++;
                  if(prices[i] > prices[j]) {
                      break;
                  }
              }
              answer.add(cnt);
          }
        
        return answer.stream().mapToInt(x->x).toArray();
    }
}

//         Queue<Integer> queue = new LinkedList<>();
        
//         for(int i : prices) queue.offer(i);
        
//         int size = queue.size();
        
//         for(int i=0; i<size; i++) {
//             int num = queue.poll();
//             int cnt = 0;
//             for(int j=i+1; j<size; j++) {
//                 cnt++;
//                 if(num > prices[j]) {
//                     break;
//                 }
//             }
//             answer.add(cnt);
//         }
