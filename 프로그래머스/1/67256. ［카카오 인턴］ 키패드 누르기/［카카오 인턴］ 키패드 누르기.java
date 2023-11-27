class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int left = -1;
        int right = -1;
        
        for(int i=0; i<numbers.length; i++) {
            if(numbers[i] % 3 == 1) {
                System.out.println("1");
                answer += "L";
                left = numbers[i];
            } else if(numbers[i] % 3 == 0 && numbers[i] != 0) {
                System.out.println("0");
                answer += "R";
                right = numbers[i];
            } else if(numbers[i] % 3 == 2 || numbers[i] == 0) {
                System.out.println("2");
                int leftDis = getDistance(left, numbers[i]);
                int rightDis = getDistance(right, numbers[i]);
                System.out.println("left = " + leftDis + " right = " + rightDis);
                
                if(leftDis < rightDis) {
                    answer += "L";
                    left = numbers[i];
                } else if(leftDis > rightDis) {
                    answer += "R";
                    right = numbers[i];
                } else if(leftDis == rightDis) {
                    if(hand.equals("right")) {
                        answer += "R";
                        right = numbers[i];
                    } else {
                        answer += "L";
                        left = numbers[i];
                    }
                }
            }
        }
        
        return answer;
    }
    
    
    static int getDistance(int way, int number) {
        int[][] keypad = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {-1, 0, -1}};
        int[] wayLoc = new int[2];
        int[] numLoc = new int[2];
        
        
        for(int i=0; i<4; i++) {
            for(int j=0; j<3; j++) {
                if(keypad[i][j] == way) {
                    wayLoc[0] = i;
                    wayLoc[1] = j;
                }
                if(keypad[i][j] == number) {
                    numLoc[0] = i;
                    numLoc[1] = j;
                }
            }
        }
        
        return Math.abs(wayLoc[0] - numLoc[0]) + Math.abs(wayLoc[1] - numLoc[1]);
    }
}