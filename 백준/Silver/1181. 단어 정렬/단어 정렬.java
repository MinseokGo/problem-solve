import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        int num = Integer.parseInt(a);

        String[] str = new String[num];
        for(int i=0; i<num; i++) {
            str[i] = scanner.nextLine();
        }
        Arrays.sort(str, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				if(s1.length() == s2.length()) {
					return s1.compareTo(s2);
				} else {
					return s1.length() - s2.length();
				}
			}
        });
        System.out.println(str[0]);
	   	 	for(int i = 1; i < num; i++) {
	   		    if (!str[i].equals(str[i - 1])) {
				    System.out.println(str[i]);
			    }
            }
    }
}
