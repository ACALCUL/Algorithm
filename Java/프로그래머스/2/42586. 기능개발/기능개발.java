import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> works = new ArrayDeque<>();
        for(int i=0; i<progresses.length; i++){
            works.offer(i);
        }
        List<Integer> answerList = new ArrayList<>();
        int day = 1;
        while(!works.isEmpty()){
            int worksOnDay = 0;
            while(!works.isEmpty() && 
                  progresses[works.peek()]+speeds[works.peek()]*day >= 100){
                works.poll();
                worksOnDay++;
            }
            if(worksOnDay > 0){
                answerList.add(worksOnDay);
            }
            day++;
        }
        
        int[] answer = answerList.stream().mapToInt(Integer:: intValue).toArray();
        return answer;
    }
}