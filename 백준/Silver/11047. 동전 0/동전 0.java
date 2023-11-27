import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[]args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = 0;

        String[] str = br.readLine().split("\\s");
        int[] num = new int[2];
        num[0] = Integer.parseInt(str[0]);
        num[1] = Integer.parseInt(str[1]);

        int[] cate = new int[num[0]];
        for(int i=cate.length-1; i>=0; i--) {
            cate[i] = Integer.parseInt(br.readLine());
        }

        for(int i=0; i<cate.length; i++) {
            if(num[1] - cate[i] >= 0) {
                cnt += num[1]/cate[i];
                num[1] -= (num[1]/cate[i])*cate[i];
            }
            if(num[1] == 0) {
                System.out.println(cnt);
                break;
            }
        }
    }
}