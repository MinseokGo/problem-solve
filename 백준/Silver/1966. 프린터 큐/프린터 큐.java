import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int caseNum = Integer.parseInt(br.readLine());

        for(int i=0; i<caseNum; i++) {
            StringTokenizer str1 = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(str1.nextToken());
            int M = Integer.parseInt(str1.nextToken());

            str1 = new StringTokenizer(br.readLine());
            Queue<Integer> queue = new LinkedList<>();
            Queue<Integer> idx = new LinkedList<>();
            for(int j=0; j<N; j++) {
                queue.add(Integer.parseInt(str1.nextToken()));
                idx.add(j);
            }
            int cnt = 1;
            while(!queue.isEmpty()) {
                int max = Collections.max(queue);
                int cur = queue.poll();
                int curidx = idx.poll();

                if(cur == max) {
                    if(curidx == M) {
                        System.out.println(cnt);
                    }
                    cnt++;
                } else {
                    queue.add(cur);
                    idx.add(curidx);
                }
            }
        }
    }
}