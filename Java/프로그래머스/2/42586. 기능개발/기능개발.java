import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        // for(int i=0; i<speeds.length; i++){
        //     System.out.println( getDays(progresses[i], speeds[i]) );
        // }
        List<Integer> solList = new ArrayList<>();
        int curDay=0;
        int progressNum=0;
        for(int i=0; i<speeds.length; i++){
            int durationDay = getDays(progresses[i], speeds[i]);
            if(curDay < durationDay){ //등호는 어디에 넣을지 고민
                solList.add(progressNum);
                progressNum=0;
                curDay = durationDay;
                progressNum++;
            }else{
                progressNum++;
            }
        }
        solList.add(progressNum);
        
        int[] sol = new int[solList.size()-1];
        for(int i=1; i<solList.size(); i++){
            sol[i-1] = solList.get(i);
        }
        return sol;
    }
    
    public int getDays(int progress, int speed){
        int days = (100-progress)/speed;
        if((100-progress)%speed!=0){
            days++;
        }
        return days;
    }
}