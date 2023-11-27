import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringTokenizer[] stringTokenizers = new StringTokenizer[N];

        for(int i=0; i<N; i++) {
            stringTokenizers[i] = new StringTokenizer(br.readLine());
        }

        for(int i=0; i<N; i++) {
            String command = stringTokenizers[i].nextToken();

            if(command.equals("push")) {
                stack.push(Integer.parseInt(stringTokenizers[i].nextToken()));
            } else if(command.equals("top")) {
                if(stack.isEmpty()) {
                    System.out.println("-1");
                    continue;
                }
                int top = stack.pop();
                System.out.println(top);
                stack.push(top);
            } else if(command.equals("size")) {
                System.out.println(stack.size());
            } else if(command.equals("empty")) {
                if(stack.isEmpty()) {
                    System.out.println("1");
                } else {
                    System.out.println("0");
                }
            } else if(command.equals("pop")) {
                if(stack.isEmpty()) {
                    System.out.println("-1");
                    continue;
                }
                System.out.println(stack.pop());
            }
        }
    }
}