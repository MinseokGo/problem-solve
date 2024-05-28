import java.util.*;
import java.util.Collections;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        List<Integer> values = new ArrayList<>(map.values());
        Collections.sort(values, (o1, o2) -> o2 - o1);
        for (int value : values) {
            for (String key : map.keySet()) {
                if (map.get(key) == value) {
                    List<Integer> orders = new ArrayList<>();
                    for (int i = 0; i < genres.length; i++) {
                        if (key.equals(genres[i])) {
                            orders.add(i);
                        }
                    }
                    if (orders.size() > 1) {
                        Collections.sort(orders, new Comparator<Integer>() {
                            @Override
                            public int compare(Integer a, Integer b) {
                                if (plays[a] > plays[b]) {
                                    return -1;
                                } else if (plays[a] == plays[b]) {
                                    return a - b;
                                } else {
                                    return 1;
                                }
                            }
                        });
                        answer.add(orders.get(0));
                        answer.add(orders.get(1));
                    } else {
                        answer.add(orders.get(0));
                    }
                }
            }
        }
        
        return answer.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}