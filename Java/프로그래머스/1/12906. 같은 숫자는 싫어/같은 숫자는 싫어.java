import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i: arr){
            queue.offer(i);
        }
        
        List<Integer> answerList = new ArrayList<>();
        int lastValue = -1;
        while(!queue.isEmpty()){
            int i = queue.poll();
            if(lastValue != i){
                answerList.add(i);
            }
            lastValue = i;
        }
        
        int[] answer = new int[answerList.size()];
        for(int i=0; i<answerList.size(); i++){
            answer[i]=answerList.get(i);
        }

        return answer;
    }
}