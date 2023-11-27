import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        ArrayList<Integer> list = new ArrayList<Integer>();

        for(int i=0; i<num; i++) list.add(Integer.parseInt(br.readLine()));

        Collections.sort(list);

        for(int n : list) bw.write(n + "\n");

        br.close();
        bw.flush();
        br.close();
    }
}
