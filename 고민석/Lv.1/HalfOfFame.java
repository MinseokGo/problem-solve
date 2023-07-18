import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        List<Integer> answer = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();  //낮은 숫자가 우선순위를 가짐
        
        for(int num : score) {
            pq.add(num);
            if(pq.size() > k)
                pq.poll();  //작은 수 제거
            answer.add(pq.peek());  //값을 제거하진 않고 값만 가져옴
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
//풀리긴 하지만 살짝 쓰레기 코드
//List<Integer> list = new ArrayList<>();
//         List<Integer> answer = new ArrayList<>();
        
//         for(int num : score) {
//             if(list.size() < k) {
//                 list.add(num);
//             } else {
//                 list.sort(Comparator.reverseOrder());
//                 if(list.get(list.size()-1) >= num) {
                    
//                 } else {
//                     list.remove(list.size()-1);
//                     list.add(num);
//                 }
//             }
//             list.sort(Comparator.reverseOrder());
//             answer.add(list.get(list.size()-1));
//         }
        
        
