import java.util.*;

class Solution {
    public String solution(String number, int k) {// k: 삭제할 원소 개수
        Deque<Character> stack = new ArrayDeque<>();
        for(char c: number.toCharArray()){
            while(!stack.isEmpty() && stack.peek()<c && k-->0){
                stack.pop();
            }
            stack.push(c);
        }
        while(k-- >0){
            stack.pop();
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pollLast());
        }
        return sb.toString();
    }
}