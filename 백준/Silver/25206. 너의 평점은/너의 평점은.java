import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] str = new String[20];
        float result = 0.0f;
        float num = 0.0f;

        for(int i=0; i<str.length; i++) {
            str[i] = scanner.nextLine();
        }
        for(int i=0; i<str.length; i++) {
            String[] a = str[i].split("\\s");
            float a2 = Float.parseFloat(a[1]);
            if(!a[2].equals("P")) {
                if(a[2].equals("A+")) {
                    result += 4.5 * a2;
                } else if(a[2].equals("A0")) {
                    result += 4.0 * a2;
                } else if(a[2].equals("B+")) {
                    result += 3.5 * a2;
                } else if(a[2].equals("B0")) {
                    result += 3.0 * a2;
                } else if(a[2].equals("C+")) {
                    result += 2.5 * a2;
                } else if(a[2].equals("C0")) {
                    result += 2.0 * a2;
                } else if(a[2].equals("D+")) {
                    result += 1.5 * a2;
                } else if(a[2].equals("D0")) {
                    result += 1.0 * a2;
                } else if(a[2].equals("F")) {
                    result += 0;
                }
                num += a2;
            }
        }
        System.out.print(result/num);
    }
}
