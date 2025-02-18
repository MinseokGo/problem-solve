import java.util.*;

class Solution {
    
    private static void init(Map<String, Integer> dictionary) {
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            dictionary.put(String.valueOf(ch), ch - 'A' + 1);
        }
    }
    
    public int[] solution(String msg) {
        List<Integer> indexes = new ArrayList<>();
        
        Map<String, Integer> dictionary = new HashMap<>();
        init(dictionary);
        
        int index = 27;
        boolean isContinued = true;
        for (int i = 0; i < msg.length(); i++) {
            if (!isContinued) {
                break;
            }
            
            String chars = String.valueOf(msg.charAt(i));
            int j = i + 1;;
            String prev = chars;
            
            while (true) {
                if (dictionary.containsKey(chars)) {
                    if (j == msg.length()) {
                        indexes.add(dictionary.get(chars));
                        isContinued = false;
                        break;
                    }
                    prev = chars;
                    chars += String.valueOf(msg.charAt(j));
                    j++;
                } else {
                    dictionary.put(chars, index);
                    indexes.add(dictionary.get(prev));
                    index++;
                    i += prev.length() - 1;
                    break;
                }
            }
        }
        
        return indexes.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();
    }
}