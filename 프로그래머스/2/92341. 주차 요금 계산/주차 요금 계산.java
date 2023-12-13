import java.util.*;
import java.time.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, String> times = new LinkedHashMap<>();
        Map<String, Integer> minutes = new LinkedHashMap<>();
        
        for (String record : records) {
            StringTokenizer st = new StringTokenizer(record);
            String time = st.nextToken();
            String number = st.nextToken();
            String state = st.nextToken();
            
            if (state.equals("IN")) {
                times.put(number, time);
            }
            if (state.equals("OUT")) {
                String inTime = times.get(number);
                times.remove(number);
                minutes.put(number, minutes.getOrDefault(number, 0) + price(inTime, time));
            }
        }
        
        for (String key : times.keySet()) {
            minutes.put(key, minutes.getOrDefault(key, 0) 
                        + price(times.get(key), "23:59"));
        }
        
        Map<String, Integer> tree = new TreeMap<>(minutes);
        
        int[] answer = new int[tree.size()];
        int i = 0;
        for (String key : tree.keySet()) {
            if (tree.get(key) > fees[0]) {
                answer[i] = (int)Math.ceil
                    ((tree.get(key) - fees[0]) / (double)fees[2])
                    * fees[3] + fees[1];
            } else {
                answer[i] = fees[1];
            }
            i++;
        }
        
        
        
        return answer;
    }
    
    public int price(String time1, String time2) {
        LocalTime local1 = LocalTime.parse(time1);
        LocalTime local2 = LocalTime.parse(time2);
        
        Duration dur = Duration.between(local1, local2);
        long min = dur.toMinutes();
        return (int) min;
    }
}