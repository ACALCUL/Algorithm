import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        String[] words = {"aya", "ye", "woo", "ma"};
        
        int answer = 0;
        for(String s:babbling){
            //System.out.println("현재 s: "+s);
            int offset = 0;
            while(offset<s.length()){
                boolean loopValid = false;
                for(String word: words){
                    int wordLen = word.length();
                    if(offset+wordLen<=s.length() && word.equals(s.substring(offset, offset+wordLen))){
                        //System.out.printf("현재 word: %s, 현재 offset: %d, 바뀐 offset: %d\n", word, offset, offset+wordLen);
                        offset+=wordLen;
                        loopValid = true;
                        break;
                    }
                }
                if(!loopValid){
                    break;
                }
            }
            if(offset>=s.length()){
                answer++;
            }
            
        }
        
        return answer;
    }
}