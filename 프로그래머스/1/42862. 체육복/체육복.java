import java.util.*;

class Solution {

    public int solution(int n, int[] lost, int[] reserve) {
        Set<Integer> reserves = new HashSet<>();
        Set<Integer> losts = new HashSet<>();
        
        for (int student : reserve) {
            reserves.add(student);
        }
        
        for (int student : lost) {
            if (reserves.contains(student)) {
                reserves.remove(student);
                continue;
            }
            losts.add(student);
        }
        
        for (int student : losts) {
            if (reserves.contains(student - 1)) {
                reserves.remove(student - 1);
                continue;
            } else if (reserves.contains(student + 1)) {
                reserves.remove(student + 1);
                continue;
            } 
            n -= 1;
        }
        
        return n;
    }
}