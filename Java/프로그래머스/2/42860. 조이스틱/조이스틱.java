import java.util.*;
class Solution {
    public int solution(String name) {
        int answer = 0;
        int length = name.length();
        int move = length-1;
        for(int i=0; i<name.length(); i++){
            int offset = (int)(name.charAt(i)-'A');
            if(offset<13){
                answer+=offset;
            }else{
                answer+=26-offset;
            }
            
            int nextIndex = i+1;
            while(nextIndex < length && name.charAt(nextIndex)=='A'){
                nextIndex++;
            }
            
            move = Math.min(move, 2*i+(length-nextIndex));
            move = Math.min(move, 2*(length-nextIndex)+i);
        }
        answer+=move;
        return answer;
    }
}