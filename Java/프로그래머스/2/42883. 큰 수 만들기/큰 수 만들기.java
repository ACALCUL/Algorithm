import java.util.*;

class Solution {
    public String solution(String number, int k) {
        int removeCount = k; //삭제할 원소의 개수
        Deque<Character> stack = new ArrayDeque<>();
        for(char c: number.toCharArray()){
            while(!stack.isEmpty() && stack.peek()<c 
               && removeCount>0){
                stack.pop();
                removeCount--;
            }
            stack.push(c);
        }
        while(removeCount-- >0){
            stack.pop();
        }
        
        char[] charArray = new char[number.length()-k];
        for(int i=number.length()-k-1; i>=0; i--){
            if(!stack.isEmpty()){
                charArray[i]=stack.pop();
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(char c: charArray){
            sb.append(c);
        }
        return sb.toString();
    }
}