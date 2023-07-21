import java.util.*;

class Solution {
    public String solution(int[] food) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        for(int i=1; i<food.length; i++) {
            sb.append(String.valueOf(i).repeat(food[i]/2));
        }
        
        answer = sb + "0";  //물
        
        return answer + sb.reverse();
    }
}
//보여주기식 하드 코딩 
//for(int i=1; i<food.length; i++) {
//             int len = food[i] / 2;
//             for(int j=0; j<len; j++) {
//                 answer += String.valueOf(i);
//             }
//         }
        
//         answer += "0";
        
//         for(int i=food.length-1; i>=1; i--) {
//             int len = food[i] / 2;
//             for(int j=0; j<len; j++) {
//                 answer += String.valueOf(i);
//             }
//         }
        
