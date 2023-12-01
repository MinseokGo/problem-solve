import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Integer> orders = new HashMap<>();
        Map<String, Integer> counts = new LinkedHashMap<>();
        Map<String, Integer> result = new LinkedHashMap<>();
        List<Person> persons = new ArrayList<>();
        
        for (int i = 0; i < id_list.length; i++) {
            Person person = new Person(id_list[i]);
            orders.put(id_list[i], i);
            counts.put(id_list[i], 0);
            result.put(id_list[i], 0);
            persons.add(person);
        }
        
        for (int i = 0; i < report.length; i++) {
            StringTokenizer st = new StringTokenizer(report[i]);
            String username = st.nextToken();
            int idx = orders.get(username);
            Person person = persons.get(idx);
            person.addReport(st.nextToken());
        }
        
        for (int i = 0; i < persons.size(); i++) {
            Set<String> sets = persons.get(i).getReports();
            Iterator iter = sets.iterator();
            while(iter.hasNext()) {
                String str = String.valueOf(iter.next());
                counts.put(str, counts.getOrDefault(str, 0) + 1);
            }
        }
        
        for (String key : counts.keySet()) {
            if (counts.get(key) >= k) {
                for (int i = 0; i < persons.size(); i++) {
                    Set<String> sets = persons.get(i).getReports();
                    if (sets.contains(key)) {
                        result.put(persons.get(i).getName(), result.getOrDefault(persons.get(i).getName(), 0) + 1);
                    }
                }
            }
        }
        List<Integer> answer = new ArrayList<>();
        for (String key : result.keySet()) {
            answer.add(result.get(key));
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    class Person {
        private final String name;
        private Set<String> reports = new HashSet<>();
        
        public Person(final String name) {
            this.name = name;
        }
        
        public String getName() {
            return name;
        }
        
        public Set<String> getReports() {
            return reports;
        }
        
        public void addReport(final String name) {
            reports.add(name);
        }
    }
}