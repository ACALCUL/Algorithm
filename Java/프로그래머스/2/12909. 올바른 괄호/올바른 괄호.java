import java.util.*;

class Solution {
    boolean solution(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        
        for(char c: s.toCharArray()){
            if(c=='('){
                stack.push(1);
            }else{ // ')'일 경우
                if(stack.isEmpty()){
                    return false;
                }else{
                    stack.pop();
                }
            }
        }
        
        return stack.isEmpty()?true:false;
    }
}