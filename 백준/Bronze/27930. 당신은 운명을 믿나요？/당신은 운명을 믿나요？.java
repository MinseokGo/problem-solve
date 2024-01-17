import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String S = in.readLine();
        
        char []yonsei = {'Y','O','N','S','E','I'};
        int yIdx = 0;
        char []korea = {'K','O','R','E','A'};
        int kIdx = 0;
        
        for(int i=0;i<S.length();i++) {
        	if(S.charAt(i) == yonsei[yIdx]) {
        		yIdx++;
        		
        	}
        	if(S.charAt(i) == korea[kIdx]) {
        		kIdx++;
        		
        	}
        	if(yIdx == yonsei.length) {
    			System.out.println("YONSEI");
    			break;
    		}
        	if(kIdx == korea.length) {
        		System.out.println("KOREA");
        		break;
        	}
        }
        
        
        
        
	}
}