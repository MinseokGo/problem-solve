import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;
    static int start;
    static int[][] linked;
    static boolean[] visited;
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        start = Integer.parseInt(stk.nextToken());
        linked = new int[N+1][N+1];
        visited = new boolean[N+1];

        for(int i=0; i<M; i++) {
            stk = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());

            linked[x][y] = linked[y][x] = 1;
        }

        dfs(linked, visited, start);

        visited = new boolean[N+1];
        System.out.println();

        bfs(linked, visited, start);
    }

    static void dfs(int[][] linked, boolean[] visited, int start) {
        visited[start] = true;
        System.out.print(start + " ");
        for(int i=1; i<=linked.length-1; i++) {
            if(linked[start][i] == 1 && visited[i] == false) dfs(linked, visited, i);
        }
    }

    static void bfs(int[][] linked, boolean[] visited, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        System.out.print(start + " ");

        while(!queue.isEmpty()) {
            int search = queue.poll();
            for(int i=1; i<=linked.length-1; i++) {
                if(linked[search][i] == 1 && visited[i] == false) {
                    queue.add(i);
                    visited[i] = true;
                    System.out.print(i + " ");
                }
            }
        }
    }
}