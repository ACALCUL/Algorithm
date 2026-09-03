import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        
        int day = 1;
        int funcNum = 0;
        for(int i=0; i<progresses.length; i++){
            while(progresses[i]+day*speeds[i]<100){
                day++;
            }
            funcNum++;
            //System.out.printf("i: %d, day: %d, funcNum: %d\n", i, day, funcNum);
            if( i==progresses.length-1 || progresses[i+1]+day*speeds[i+1]<100) {
                list.add(funcNum);
                funcNum=0;
            }
            
        }
        
        int[] answer= new int[list.size()];
        for(int i =0; i<list.size(); i++){
            answer[i]=list.get(i);
        }
        return answer;
    }
}