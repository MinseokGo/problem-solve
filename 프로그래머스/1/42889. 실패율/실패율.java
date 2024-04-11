import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int N, int[] stages) {
        Map<Integer, Double> map = new HashMap<>();
        
        for (int i = 1; i <= N; i++) {
            int nonClear = 0;
            int reach = 0;
            for (int j = 0; j < stages.length; j++) {
                if (stages[j] < i) continue;
                if (stages[j] == i) {
                    nonClear++;
                    reach++;
                    continue;
                }
                if (stages[j] > i) {
                    reach++;
                }
            }
            if (reach != 0) {
                map.put(i, (double) nonClear/reach);
            }
            if (reach == 0) {
                map.put(i, 0.0);
            }
        }
        
        List<Double> rates = new ArrayList<>(map.values());
        Collections.sort(rates);
        
        List<Integer> result = new ArrayList<>();
        for (int j = rates.size() - 1; j >= 0; j--) {
            double rate = rates.get(j);
            for (int i = 1; i <= N; i++) {
                double value = map.get(i);
                if (rate == value && !result.contains(i)) {
                    result.add(i);
                }
            }
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}