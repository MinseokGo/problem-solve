import java.util.*;

class Solution {
    boolean solution(String s) {
        return s.toUpperCase().chars().filter(i -> i == 'P').count()
            == s.toUpperCase().chars().filter(i -> i == 'Y').count();
    }
}