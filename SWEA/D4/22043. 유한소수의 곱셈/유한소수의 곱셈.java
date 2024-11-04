import java.io.*;
import java.util.*;

public class Solution {
    static int OFFSET = 40; // net2i와 net5i의 범위를 양수로 만들기 위한 오프셋
    static int SIZE = 2 * OFFSET + 1; // 가능한 net 값의 범위 [-40, 40]을 [0, 80]으로 매핑

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 테스트 케이스 수 입력
        int T = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();
        for (int test = 0; test < T; test++) {
            int n = Integer.parseInt(br.readLine());
            int[] net2 = new int[n];
            int[] net5 = new int[n];

            for (int i = 0; i < n; i++) {
                String s = br.readLine();
                int[] net = getNet2Net5(s);
                net2[i] = net[0];
                net5[i] = net[1];
            }

            long totalPairs = 0;
            BIT2D bit = new BIT2D(SIZE);
            for (int i = 0; i < n; i++) {
                int net2i = net2[i];
                int net5i = net5[i];
                // 쿼리: net2j >= -net2i AND net5j >= -net5i
                int x1 = -net2i + OFFSET;
                int y1 = -net5i + OFFSET;
                totalPairs += bit.queryRange(x1, y1, SIZE - 1, SIZE - 1);
                // 업데이트: net2i, net5i 위치에 +1
                int x = net2i + OFFSET;
                int y = net5i + OFFSET;
                bit.update(x, y, 1);
            }
            output.append(totalPairs).append("\n");
        }
        System.out.print(output);
    }

    // net2와 net5를 계산하는 함수
    static int[] getNet2Net5(String s) {
        int exponent2Numerator = 0, exponent5Numerator = 0;
        int exponent2Denominator = 0, exponent5Denominator = 0;
        long numerator, denominator;

        if (!s.contains(".")) {
            // 정수인 경우
            numerator = Long.parseLong(s);
            denominator = 1;
        } else {
            // 소수인 경우
            int decimalPointIndex = s.indexOf('.');
            int fractionalLength = s.length() - decimalPointIndex - 1;
            String integerPart = s.substring(0, decimalPointIndex);
            String fractionalPart = s.substring(decimalPointIndex + 1);
            numerator = Long.parseLong(integerPart + fractionalPart);
            denominator = (long) Math.pow(10, fractionalLength);
        }

        // 분자와 분모의 최대공약수로 약분
        long gcd = gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;

        // 분자와 분모에서 2와 5의 지수를 계산
        exponent2Numerator = countFactor(numerator, 2);
        exponent5Numerator = countFactor(numerator, 5);
        exponent2Denominator = countFactor(denominator, 2);
        exponent5Denominator = countFactor(denominator, 5);

        int net2 = exponent2Numerator - exponent2Denominator;
        int net5 = exponent5Numerator - exponent5Denominator;

        return new int[]{net2, net5};
    }

    // 소인수분해하여 특정 소수의 지수를 계산하는 함수
    static int countFactor(long num, int factor) {
        int count = 0;
        while (num % factor == 0 && num > 0) {
            num /= factor;
            count++;
        }
        return count;
    }

    // 최대공약수를 계산하는 함수
    static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    // 2D 펜윅 트리 구현
    static class BIT2D {
        int size;
        long[][] tree;

        BIT2D(int size) {
            this.size = size;
            tree = new long[size + 2][size + 2]; // 1-indexed
        }

        void update(int x, int y, long val) {
            x++; y++; // 1-indexed
            for (int xi = x; xi <= size + 1; xi += xi & -xi) {
                for (int yi = y; yi <= size + 1; yi += yi & -yi) {
                    tree[xi][yi] += val;
                }
            }
        }

        long query(int x, int y) {
            x++; y++; // 1-indexed
            long sum = 0;
            for (int xi = x; xi > 0; xi -= xi & -xi) {
                for (int yi = y; yi > 0; yi -= yi & -yi) {
                    sum += tree[xi][yi];
                }
            }
            return sum;
        }

        // (x1, y1)부터 (x2, y2)까지의 합을 구하는 함수
        long queryRange(int x1, int y1, int x2, int y2) {
            return query(x2, y2) - query(x1 - 1, y2) - query(x2, y1 - 1) + query(x1 - 1, y1 - 1);
        }
    }
}
