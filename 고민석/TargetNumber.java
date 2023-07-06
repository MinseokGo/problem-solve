class Solution {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, target, 0);
        
        return answer;
    }
    static void dfs(int[] numbers, int depth, int target, int sum) {
        //1. 길이가 같은데 sum을 충족하지 않을 경우 두번째 if문을 고려하긴 하므로 else(루프 가능성)를 고려하지 않음. 무한 루프 x
        //2. 길이도 같고 sum을 충족하는 경우는 당연히 else를 고려하지 않음. 무한 루프 x
        if(depth == numbers.length) {
            if(sum == target) {
                answer++;
            }
        } else {
            dfs(numbers, depth + 1, target, sum + numbers[depth]);
            dfs(numbers, depth + 1, target, sum - numbers[depth]);
        }
    }
}
