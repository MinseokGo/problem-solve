import java.util.*;

class Solution {
    
    List<String> answer;
    boolean found = false;
    
    public String[] solution(String[][] tickets) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (String[] ticket : tickets) {
            String from = ticket[0];
            String to = ticket[1];
            
            map.putIfAbsent(from, new ArrayList<>());
            map.get(from).add(to);
        }
        
        for (String key : map.keySet()) {
            Collections.sort(map.get(key));
        }
        
        answer = new ArrayList<>();
        List<String> route = new ArrayList<>();
        route.add("ICN");
        
        dfs("ICN", route, map, tickets.length);
        
        return answer.toArray(new String[answer.size()]);
    }
    
    private void dfs(
        String current,
        List<String> route,
        Map<String, List<String>> map,
        int ticketCount
    ) {
        if (route.size() == ticketCount + 1) {
            answer = new ArrayList<>(route);
            found = true;
            return;
        }
        
        if (map.containsKey(current)) {
            List<String> nextList = map.get(current);
            for (int i = 0; i < nextList.size(); i++) {
                String dest = nextList.get(i);
                if (dest == null) {
                    continue;
                }
                
                nextList.set(i, null);
                route.add(dest);
                dfs(dest, route, map, ticketCount);
                
                if (found) {
                    return;
                }
                
                route.remove(route.size() - 1);
                nextList.set(i, dest);
            }
        }
    }
}
