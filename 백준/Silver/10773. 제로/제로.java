import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        int cnt = -1;
        int sum = 0;

        for(int i=0; i<num; i++) {
            int addNum = Integer.parseInt(br.readLine());
            if(addNum != 0) {
                list.add(addNum);
                cnt++;
            } else {
                list.remove(list.size() - 1);
            }
        }
        for(int i : list) sum += i;
        System.out.println(sum);
    }
}