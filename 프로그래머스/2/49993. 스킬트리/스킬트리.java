class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for (String skills : skill_trees) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < skills.length(); i++) {
                char ch = skills.charAt(i);
                if (skill.contains(String.valueOf(ch))) {
                    sb.append(ch);
                }
            }
            if (skill.startsWith(sb.toString())) {
                System.out.println("possible : " + sb.toString());
                answer++;
            } else {
                System.out.println(sb.toString());
            }
        }
        
        return answer;
    }
}