import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        List<String> caches = new ArrayList<>();
        int runtime = 0;
        
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        
        for (String city : cities) {
            city = city.toUpperCase();
            if (!caches.contains(city)) {
                if (caches.size() == cacheSize) {
                    caches.remove(0);
                }
                runtime += 5;
            } else {
                caches.remove(city);
                runtime++;
            }
            caches.add(city);
        }

        return runtime;
    }
}