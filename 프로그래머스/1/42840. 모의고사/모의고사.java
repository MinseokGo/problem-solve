import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] first = {1, 2, 3, 4, 5};
        int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] corrects = new int[3];
        
        for (int i = 0; i < answers.length; i++) {
            if (first[i % first.length] == answers[i]) {
                corrects[0]++;
            }
            if (second[i % second.length] == answers[i]) {
                corrects[1]++;
            }
            if (third[i % third.length] == answers[i]) {
                corrects[2]++;
            }
        }
        
        final int maxCorrect = Arrays.stream(corrects)
            .max()
            .getAsInt();
        
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < corrects.length; i++) {
            if (maxCorrect == corrects[i]) {
                result.add(i + 1);
            }
        }
        
        return result.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}