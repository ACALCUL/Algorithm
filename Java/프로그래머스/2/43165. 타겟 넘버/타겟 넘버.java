import java.util.*;

class Solution {
    class Element{
        int depth;
        int sum;
        Element(int depth, int sum){
            this.depth = depth;
            this.sum = sum;
        }    
    }
    
    public int solution(int[] numbers, int target) {
        int answer;
        // answer = stackDfs(numbers, target);
        answer = recurDfs(numbers, target, -1, 0);
        return answer;
    }
    
    // 자바는 최대 깊이(동시 점유 함수)가 1000이상 일때 재귀를 피해야 한다
    // -> 이 문제는 재귀 dfs 가능
    
    private int recurDfs(int[] numbers, int target, int depth, int sum){
        if(depth == numbers.length-1){
            return sum==target?1:0;
        }
        return recurDfs(numbers, target, depth+1, sum+numbers[depth+1])
            +recurDfs(numbers, target, depth+1, sum-numbers[depth+1]);
    }
    
    private int stackDfs(int[] numbers, int target){
        int cnt = 0;
        Deque<Element> stack = new ArrayDeque<>();
        stack.push(new Element(0, numbers[0]));
        stack.push(new Element(0, -numbers[0]));
        while(!stack.isEmpty()){
            Element curElement = stack.pop();
            int curDepth = curElement.depth;
            int curSum = curElement.sum;
            
            if(curDepth == numbers.length-1){
                if(curSum == target){ cnt++; }
                continue;
            }
            
            stack.push(new Element(curDepth+1, curSum+numbers[curDepth+1]));
            stack.push(new Element(curDepth+1, curSum-numbers[curDepth+1]));
        }
        return cnt;
    }
}