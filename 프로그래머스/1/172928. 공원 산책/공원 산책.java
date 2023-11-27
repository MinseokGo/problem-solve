import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        int h = park.length;
        int w = park[0].length();
        
        for (int i=0; i<park.length; i++) {
            if(park[i].contains("S")) {
                for(int j=0; j<w; j++) {
                    if (park[i].charAt(j) == 'S') {
                        answer[0] = i;
                        answer[1] = j;
                    }
                }
            }
        }
        
        for (String route : routes) {
            boolean isPrime = true;
            String[] strs = route.split(" ");
            String dir = strs[0];
            int move = Integer.parseInt(strs[1]);
            if (dir.equals("N")) {
                if (answer[0] - move >= 0) {
                    for (int i=1; i<=move; i++) {
                        if (park[answer[0]-i].charAt(answer[1]) == 'X') {
                            isPrime = false;
                            continue;
                        }
                    }
                    if(isPrime) {
                        answer[0] -= move;
                    }
                }
            }
            if (dir.equals("S")) {
                if (answer[0] + move <= h-1) {
                    for (int i=1; i<=move; i++) {
                        if (park[answer[0]+i].charAt(answer[1]) == 'X') {
                            isPrime = false;
                            continue;
                        }
                    }
                    if(isPrime) {
                        answer[0] += move;
                    }
                }
            }
            if (dir.equals("W")) {
                if (answer[1] - move >= 0) {
                    for (int i=1; i<=move; i++) {
                        if (park[answer[0]].charAt(answer[1]-i) == 'X') {
                            isPrime = false;
                            continue;
                        }
                    }
                    if (isPrime) {
                        answer[1] -= move;
                    }
                }
            }
            if (dir.equals("E")) {
                if (answer[1] + move <= w-1) {
                    for (int i=1; i<=move; i++) {
                        if (park[answer[0]].charAt(answer[1]+i) == 'X') {
                            isPrime = false;
                            continue;
                        }
                    }
                    if (isPrime) {
                        answer[1] += move;
                    }
                }
            }
        }
        
        return answer;
    }
}