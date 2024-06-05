import java.util.*;

class Solution {
    public int[] solution(String[] enrolls,
                          String[] referrals,
                          String[] sellers,
                          int[] amounts) {
        
        Map<String, String> map = new HashMap<>();
        Map<String, Integer> moneyMap = new HashMap<>();
        
        for (int i = 0; i < enrolls.length; i++) {
            map.put(enrolls[i], referrals[i]);
            moneyMap.put(enrolls[i], 0);
        }
        
        for (int i = 0; i < sellers.length; i++) {
            String seller = sellers[i];
            int money = amounts[i] * 100;
            while (map.containsKey(seller)) {
                String referral = map.get(seller);
                moneyMap.put(
                    seller,
                    moneyMap.getOrDefault(
                        seller, 0) + money - (money / 10));
                
                money /= 10;
                if ((int) Math.ceil(money * 0.1) < 1) {
                    break;
                }
                seller = referral;
            }
        }
        
        int[] answer = new int[enrolls.length];
        for (int i = 0; i < enrolls.length; i++) {
            answer[i] = moneyMap.get(enrolls[i]);
        }
        
        return answer;
    }
}