import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();
        
        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    x.add(i);
                    y.add(j);
                }
            }
        }
        
        answer[0] = x.stream().mapToInt(i -> i).min().getAsInt();
        answer[1] = y.stream().mapToInt(i -> i).min().getAsInt();
        answer[2] = x.stream().mapToInt(i -> i).max().getAsInt() + 1;
        answer[3] = y.stream().mapToInt(i -> i).max().getAsInt() + 1;
        
        return answer;
    }
}