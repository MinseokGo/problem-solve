import java.util.*;

class Solution {
    
    public int[] solution(String input) {
        input = input.substring(2, input.length() - 2);
        List<String> tuples = Arrays.asList(input.split("\\},\\{"));
        tuples.sort(Comparator.comparingInt(String::length));
        
        Set<Integer> numberSet = new LinkedHashSet<>();
        
        for (String tuple : tuples) {
            for (String number : tuple.split(",")) {
                numberSet.add(Integer.parseInt(number));
            }
        }
        
        return numberSet.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();
    }
}