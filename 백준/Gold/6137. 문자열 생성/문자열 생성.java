import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int length = Integer.parseInt(br.readLine());
        StringBuilder input = new StringBuilder();
        for (int i = 0; i < length; i++) {
            input.append(br.readLine());
        }

        int count = 0;
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < length; i++) {
            final int inputLength = input.length();
            final char first = input.charAt(0);
            final char last = input.charAt(inputLength - 1);

            if (count != 0 && count % 80 == 0) {
                output.append("\n");
            }
            if (input.length() == 1) {
                output.append(first);
                break;
            }
            if (first > last) {
                output.append(last);
                input.deleteCharAt(inputLength - 1);
            }
            if (first < last) {
                output.append(first);
                input.deleteCharAt(0);
            }
            if (first == last) {
                if (input.length() > 3) {
                    int j = 0;
                    while (true) {
                        if ((j + 1) >= (inputLength - 2 - j)) {
                            output.append(input.charAt(0));
                            input.deleteCharAt(0);
                            break;
                        }
                        if (input.charAt(j + 1) > input.charAt(inputLength - 2 - j)) {
                            output.append(input.charAt(inputLength - 1));
                            input.deleteCharAt(inputLength - 1);
                            break;
                        }
                        if (input.charAt(j + 1) < input.charAt(inputLength - 2 - j)) {
                            output.append(input.charAt(0));
                            input.deleteCharAt(0);
                            break;
                        }
                        j++;
                    }
                } else {
                    output.append(input.charAt(0));
                    input.deleteCharAt(0);
                }
            }
            count++;
        }

        System.out.print(output);
    }
}
