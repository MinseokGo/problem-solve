import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        //int 배열로 인덱스마다 개수 지정해주면 메모리 초과 뜰거같음
        //그래서 맵에다가 존재하는 귤 종류만 카운트하도록 함
        for(int i=0; i<tangerine.length; i++) 
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);

        //종류의 개수를 리스트에 담음
        for(Integer key : map.keySet()) 
            list.add(map.get(key));

        //개수가 많은 순으로 정렬
        Collections.sort(list, Collections.reverseOrder());

        //많은 순대로 꺼내서 k값을 채우면 종료
        int cnt = 0;
        for(int i=0; i<list.size(); i++) {
            if(cnt >= k) {
                 break;
            } else {
                cnt += list.get(i);
                answer++;
            }
            
        }
        
        return answer;
    }
}
