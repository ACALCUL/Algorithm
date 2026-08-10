import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        String[] words = {"aya", "ye", "woo", "ma"};
        
        int answer = 0;
        for(String s:babbling){
            //System.out.println("s: "+s);
            
            for(String word: words){
                s = s.replace(word, "1");
            }
            //System.out.println("After s: "+s);
            s = s.replace("1", "");
            if("".equals(s)){
                //System.out.println("Sucess!");
                answer++;
            }
        }
        
        return answer;
    }
}