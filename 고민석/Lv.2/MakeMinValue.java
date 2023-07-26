import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);

        //A의 젤 작은 수와 B의 젤 큰수를 곱함(B는 역순으로)
        for(int i=0; i<A.length; i++) answer += A[i] * B[B.length - 1 - i];

        return answer;
    }
}

//우선순위 큐 사용
//속도는 위에꺼보다 조금 느린데
//while문을 for문으로 A의 사이즈만큼 돌리면 시간초과 뜸
//PriorityQueue<Integer> pq1 = new PriorityQueue<>();
// PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
// for(int i=0; i<A.length; i++) {
//     pq1.add(A[i]);
//     pq2.add(B[i]);
// }
// while(!pq1.isEmpty()) {
//     answer += pq1.poll() * pq2.poll();
// }

//시간 초과 뜨는 처음에 작성한 코드
//쓰레기
//         Integer[] copyB = Arrays.stream(B).boxed().toArray(Integer[]::new);

//         Arrays.sort(A);
//         Arrays.sort(copyB, Collections.reverseOrder());
        
//         for(int i=0; i<A.length; i++) answer += A[i] * copyB[i];
