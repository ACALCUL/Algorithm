import java.util.*;

class Solution {
    boolean solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for(char c: s.toCharArray()){
            if(c=='('){
                stack.push('(');
            }else if(c==')'){
                if(stack.isEmpty()){
                    return false;
                } else{
                    stack.pop();
                }
            }
        }

        return stack.isEmpty()?true:false;
    }
}