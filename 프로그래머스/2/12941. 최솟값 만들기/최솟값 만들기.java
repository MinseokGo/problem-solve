import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        for(int i=0; i<A.length; i++) answer += A[i] * B[B.length - 1 - i];

        return answer;
    }
}

        //PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        // PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
        // for(int i=0; i<A.length; i++) {
        //     pq1.add(A[i]);
        //     pq2.add(B[i]);
        // }
        // while(!pq1.isEmpty()) {
        //     answer += pq1.poll() * pq2.poll();
        // }


//         Integer[] copyB = Arrays.stream(B).boxed().toArray(Integer[]::new);

//         Arrays.sort(A);
//         Arrays.sort(copyB, Collections.reverseOrder());
        
//         for(int i=0; i<A.length; i++) answer += A[i] * copyB[i];