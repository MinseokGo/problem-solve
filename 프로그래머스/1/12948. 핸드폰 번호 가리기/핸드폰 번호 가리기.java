import java.util.*;

class Solution {
    public String solution(String phone_number) {
        String str1 = phone_number.substring(0, phone_number.length()-4);
        String str2 = phone_number.substring(phone_number.length()-4, phone_number.length());
        
        str1 = str1.replaceAll("[0-9]", "*");
        
        return str1 + str2;
    }
}