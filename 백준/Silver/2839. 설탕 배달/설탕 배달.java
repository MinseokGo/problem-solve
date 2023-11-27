import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        int kg = Integer.parseInt(a);
        int cnt = 0;

        while(true) {
            if(kg % 5 == 0) {
                System.out.println(kg/5 + cnt);
                break;
            } else if(kg < 0) {
                System.out.println(-1);
                break;
            }
            kg -= 3;
            cnt++;
        }
    }
}