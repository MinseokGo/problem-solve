import java.util.*;

class Solution {
    
    public int[] solution(String input) {
        List<Integer> answer = new ArrayList<>();
        input = input.substring(2, input.length() - 2);
        String[] strings = input.split("\\},\\{");
        List<List<Integer>> tuples = new ArrayList<>();
        
        Arrays.sort(strings, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
        for (int i = 0; i < strings.length; i++) {
            String[] numbers = strings[i].split(",");
            List<Integer> tuple = new ArrayList<>();
            
            for (int j = 0; j < numbers.length; j++) {
                tuple.add(Integer.parseInt(numbers[j]));
            }
            tuples.add(tuple);
        }
        
        Set<Integer> numberSet = new HashSet<>();
        for (List<Integer> tuple : tuples) {
            for (int number : tuple) {
                if (numberSet.add(number)) {
                    answer.add(number);
                }
            }
        }
        
        return answer.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();
    }
}