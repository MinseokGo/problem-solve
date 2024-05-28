import java.util.*;
import java.util.stream.Stream;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, ArrayList<int[]>> genresMap = new HashMap<>();
        Map<String, Integer> playMap = new HashMap<>();
        List<Integer> answer = new ArrayList<>();
        
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            
            if (!genresMap.containsKey(genre)) {
                genresMap.put(genre, new ArrayList());
                playMap.put(genre, 0);
            }
            genresMap.get(genre).add(new int[] {i, play});
            playMap.put(genre, playMap.get(genre) + play);
        }
        
        Stream<Map.Entry<String, Integer>> sortedMap = playMap.entrySet().stream()
            .sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()));
        
        sortedMap.forEach(entry -> {
            Stream<int[]> sortedEachPlays = genresMap.get(entry.getKey()).stream()
                .sorted((arr1, arr2) -> Integer.compare(arr2[1], arr1[1]))
                .limit(2);
            
            sortedEachPlays.forEach(arr -> answer.add(arr[0]));
        });
        
        return answer.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}