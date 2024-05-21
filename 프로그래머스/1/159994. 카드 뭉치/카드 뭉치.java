import java.util.*;

class Solution {
    public String solution(String[] arr1,
                           String[] arr2,
                           String[] goals) {
        
        ArrayDeque<String> cards1 = new ArrayDeque<>();
        ArrayDeque<String> cards2 = new ArrayDeque<>();
        
        for (int i = 0; i < arr1.length; i++) {
            cards1.addLast(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            cards2.addLast(arr2[i]);
        }
        
        for (int i = 0; i < goals.length; i++) {
            String goal = goals[i];
            if (!cards1.isEmpty()) {
                String card = cards1.pollFirst();
                if (card.equals(goal)) {
                    continue;
                } else {
                    cards1.addFirst(card);
                }
            }
            if (!cards2.isEmpty()) {
                String card = cards2.pollFirst();
                if (card.equals(goal)) {
                    continue;
                } else {
                    cards2.addFirst(card);
                }
            }
            return "No";
        }
        return "Yes";
    }
}