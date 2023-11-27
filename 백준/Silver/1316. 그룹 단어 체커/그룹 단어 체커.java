import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inp = scanner.nextLine();
        int num = Integer.parseInt(inp);
        String[] arr = new String[num];
        boolean[] check = new boolean[26];
        int cnt = 0;

        for(int i=0; i<num; i++)
            arr[i] = scanner.nextLine();

        for(String str : arr) {
            boolean isPrime = true;
            char prev = 'A';
            for(int i=0; i<str.length(); i++) {
                if(check[str.charAt(i)-97] == true) {
                    if(str.charAt(i) != prev) {
                        isPrime = false;
                    }
                } else {
                    check[str.charAt(i) - 97] = true;
                }
                prev = str.charAt(i);
            }
            if(isPrime) cnt++;
            for(int i=0; i<26; i++) check[i] = false;
        }
        System.out.println(cnt);

    }
}
