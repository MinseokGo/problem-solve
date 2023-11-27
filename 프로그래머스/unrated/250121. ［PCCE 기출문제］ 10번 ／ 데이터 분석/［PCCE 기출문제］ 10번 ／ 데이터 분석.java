import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by){
        int index = getIndex(ext);
        int sortIndex = getIndex(sort_by);
        
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<data.length; i++) {
            if (data[i][index] < val_ext) {
                list.add(i);
            }
        }
        int[][] answer = new int[list.size()][4];
        for (int i=0; i<list.size(); i++) {
            answer[i] = data[list.get(i)];
        }
        
        Arrays.sort(answer, new Comparator<int[]>() {
            @Override
            public int compare(int[] s1, int[] s2) {
                return s1[sortIndex] - s2[sortIndex];
            }
        });
        
        return answer;
    }
    
    private int getIndex(String ext) {
        if (ext.equals("code")) {
            return 0;
        }
        if (ext.equals("date")) {
            return 1;
        }
        if (ext.equals("maximum")) {
            return 2;
        }
        if (ext.equals("remain")) {
            return 3;
        }
        return -1;
    } 
}