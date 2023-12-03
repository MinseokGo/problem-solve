import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        Set<String> set = new HashSet<>();
        int order = 0;
        
        for(int i=0; i<words.length; i++) {
            if (i % n == 0) order++;
            if (words[i].length() == 1) {
                answer[0] = i % n + 1;
                answer[1] = order;
                return answer;
            }
            if (i >= 1 &&
                words[i - 1].charAt(words[i - 1].length() - 1) != 
                words[i].charAt(0)) {
                answer[0] = i % n + 1;
                answer[1] = order;
                return answer;
            }
            if (!set.add(words[i])) {
                answer[0] = i % n + 1;
                answer[1] = order;
                return answer;
            }
        }
        Iterator<String> iter = set.iterator();
        while (iter.hasNext()) {
            String str = iter.next();
            System.out.println(str);
        }
        
        return answer;
    }
}