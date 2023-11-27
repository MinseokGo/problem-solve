import java.io.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        int[][] arr = new int[num][2];
        String[] list = new String[num];

        for(int i=0; i<num; i++) {
            list = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(list[0]);
            arr[i][1] = Integer.parseInt(list[1]);
        }

        for(int i = 0; i < num; i++) {
            int rankIndex = 1;

            for(int j = 0; j < num; j++) {
                if(i == j) continue;
                if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1])
                    rankIndex++;
            }
            System.out.print(rankIndex + " ");
        }
    }
}