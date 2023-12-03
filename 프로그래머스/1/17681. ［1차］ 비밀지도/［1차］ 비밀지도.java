class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[arr1.length];
        
        for (int i = 0; i < arr1.length; i++) {
            String str = Long.toBinaryString(arr1[i] | arr2[i]);
            str = "0".repeat(n - str.length()) + str;
            answer[i] = str.replace("1", "#").replace("0", " ");
        }
        
        return answer;
    }
}