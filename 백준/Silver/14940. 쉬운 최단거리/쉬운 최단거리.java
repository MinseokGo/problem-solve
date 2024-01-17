import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] map = new int[1000][1000];
    static int[][] visited = new int[1000][1000];
    static int[][] dist = new int[1000][1000];
	
	
	static int N;
	static int M;
	
	public static class Pair{
		int x;
		int y;
		int d;
		
		Pair(int y,int x,int d){
			this.y =y;
			this.x = x;
			this.d = d;
		}
	}
	
	public static boolean isIn(int y,int x) {
		if(x < 0 || x >= M)return false;
		if(y < 0 || y >= N)return false;
		return true;
	}

	public static void main(String[] args) throws Exception {
		
		int [][] movepos = {{0,1},{0,-1},{1,0},{-1,0}};
		
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        //++
        //StringTokenizer st = new StringTokenizer(in.readLine());
        
        
        String [] nm = in.readLine().split(" ");
        N = Integer.parseInt(nm[0]);
        M = Integer.parseInt(nm[1]);
        //N = Integer.parseInt(st.nextToken());
        //M = Integer.parseInt(st.nextToken());
        
        int []start = new int[2];
        
        for(int i=0;i<N;i++) {
        		String [] input = in.readLine().split(" ");
        		//st = new StringTokenizer(in.readLine());
        		
        		for(int j=0;j<M;j++) {
        			map[i][j] = Integer.parseInt(input[j]);
        			//map[i][j] = Integer.parseInt(st.nextToken());
        			
        			if(map[i][j] == 2) {
        				start[0]=i;
        				start[1]=j;
        			}
        		}
        }
        
        //Queue<Pair> Q = new LinkedList<Pair>();
        Queue<int[]> Q = new LinkedList<>();
        //Q.add(new Pair(start[0],start[1],0));
        Q.add(new int[] {start[0],start[1],0});
        
        while(!Q.isEmpty()) {
        	//Pair curr = Q.peek(); Q.remove();
        	int []curr = Q.poll();
        	
        	
        	if(visited[curr[0]][curr[1]] == 1)continue;
        	visited[curr[0]][curr[1]]= 1; 
        	dist[curr[0]][curr[1]]= curr[2];
        	
        	for(int i=0;i<4;i++) {
        		int goy = curr[0] + movepos[i][0];
        		int gox = curr[1] + movepos[i][1];
        		
        		//1. isIn 함수 X?
//        		if(isIn(goy,gox)) {
        		if(0 <= goy && goy < N && 0 <= gox && gox < M ) {
        			if(visited[goy][gox] == 1)continue;
        			if(map[goy][gox]==0)continue;
        			
        			
//        			Q.add(new Pair(goy,gox,curr.d+1));
        			Q.add(new int[] {goy,gox,curr[2]+1});
        		}
        		
        	}
        }
        
        for(int i=0;i<N;i++) {
        	for(int j=0;j<M;j++) {
        		if(map[i][j] == 0) {
        			sb.append("0 ");
        		}
        		else if(visited[i][j] == 0) {
        			sb.append("-1 ");
        		}
        		else {
        			sb.append(dist[i][j]+" ");
        		}
        	}
        	sb.append("\n");
        }
        
        System.out.println(sb);
        
        
	}
}