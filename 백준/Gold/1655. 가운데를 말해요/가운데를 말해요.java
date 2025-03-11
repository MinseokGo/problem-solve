import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> right = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(br.readLine());

            if (left.isEmpty()) {
                left.offer(number);
            } else {
                if (number <= left.peek()) {
                    left.offer(number);
                } else {
                    right.offer(number);
                }
            }

            if (left.size() - right.size() == 2) {
                right.offer(left.poll());
            } else if (right.size() - left.size() == 1) {
                left.offer(right.poll());
            }

            sb.append(left.peek())
                    .append("\n");
        }

        System.out.println(sb);
    }
}
