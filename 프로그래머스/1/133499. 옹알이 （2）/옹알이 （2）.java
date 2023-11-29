import java.util.*;

class Solution {
    static boolean isYe = false;
    static boolean isMa = false;
    static boolean isAya = false;
    static boolean isWoo = false;
    public int solution(String[] babbling) {
        int answer = 0;
        
        for (String babble : babbling) {
            isYe = false;
            isMa = false;
            isAya = false;
            isWoo = false;
            boolean isPrime = true;
            String str = babble;
            while (isPrime) {
                if (babble.length() >= 2 && isTwo(babble.substring(0, 2))) {
                    System.out.println(babble + " " + babble.substring(0, 2));
                    babble = babble.substring(2);
                }
                else if (babble.length() >= 3 && isThree(babble.substring(0, 3))) {
                    System.out.println(babble + " " + babble.substring(0, 3));
                    babble = babble.substring(3);
                } 
                else if (babble.length() == 0) {
                    System.out.println(str);
                    answer++;
                    break;
                }
                else {
                    System.out.println("break : " + babble);
                    isPrime = false;
                    break;
                }
            }
        }
        
        return answer;
    }
    
    static boolean isTwo(String str) {
        if (str.equals("ye") && !isYe) {
            isYe = true;
            isMa = false;
            isAya = false;
            isWoo = false;
            return true;
        }
        if (str.equals("ma") && !isMa) {
            isYe = false;
            isMa = true;
            isAya = false;
            isWoo = false;
            return true;
        }
        return false;
    }
    
    static boolean isThree(String str) {
        if (str.equals("aya") && !isAya) {
            isYe = false;
            isMa = false;
            isAya = true;
            isWoo = false;
            return true;
        }
        if (str.equals("woo") && !isWoo) {
            isYe = false;
            isMa = false;
            isAya = false;
            isWoo = true;
            return true;
        }
        return false;
    }
}

// class Solution {
//     public int solution(String[] babbling) {
//         int answer = 0;
//         String[] announces = {"aya", "ye", "woo", "ma"};
        
//         for (String babble : babbling) {
//             String str = babble;
//             boolean isPrime = true;
//             if (isRepeat(babble, announces[0]) 
//                 || isRepeat(babble, announces[1])
//                 || isRepeat(babble, announces[2])
//                 || isRepeat(babble, announces[3])) {
//                 isPrime = false;
//             }
//             if (isPrime) {
//                 babble = babble.replaceAll(announces[0], "");
//                 babble = babble.replaceAll(announces[1], "");
//                 babble = babble.replaceAll(announces[2], "");
//                 babble = babble.replaceAll(announces[3], "");
//                 if (babble.length() == 0) {
//                     answer++;
//                 }
//             }
//         }
        
//         return answer;
//     }
//     static boolean isRepeat(String babble, String announce) {
//         String str = "";
//         for (int i = 2; i <= babble.length() / announce.length(); i++) {
//             str = announce.repeat(i);
//             if (babble.contains(str)) {
//                 System.out.println("announce " + announce + " babble " + babble);
//                 return true;
//             }
//         }
//         return false;
//     }
// }