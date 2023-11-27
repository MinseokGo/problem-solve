import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //StringTokenizer tokenizer = new StringTokenizer(br.readLine(), "\\s");

        String[] str = br.readLine().split("\\s");
        ArrayList<Integer> arr = new ArrayList<>();
        int N = Integer.parseInt(str[0]);
        int K = Integer.parseInt(str[1]);
        int a = K-1;

        for(int i=0; i<N; i++) arr.add(i+1);

        System.out.print("<");    // 1 2 4 5 7
        while(true) {
            System.out.print(arr.get(a));
            arr.remove(a);
            if(arr.size() != 0)
                a = (a + (K-1)) % arr.size();
            if(arr.isEmpty()) break;
            System.out.print(", ");
        }
        System.out.print(">");
    }
}