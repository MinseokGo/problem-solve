import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int time = bandage[0];
        int heal = bandage[1];
        int goalHeal = bandage[2];
        int maxTime = attacks[attacks.length - 1][0];
        int maxHealth = health;
        int cnt = 0;
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i=0; i<attacks.length; i++) {
            map.put(attacks[i][0], attacks[i][1]);
        }

        for (int i=1; i<=maxTime; i++) {
            if (map.containsKey(i)) {
                cnt = 0;
                health -= map.get(i);
                if (health <= 0) {
                    return -1;
                }
                continue;
            }
            cnt++;
            if (health + heal >= maxHealth) {
                health = maxHealth;
                continue;
            }
            if (health + heal <= maxHealth) {
                health += heal;
                
                if (cnt == time) {
                    if (health + goalHeal >= maxHealth) {
                        health = maxHealth;
                    } else {
                        health += goalHeal;
                    }
                    cnt = 0;
                }
            } 
        }        
        
        return health;
    }
}