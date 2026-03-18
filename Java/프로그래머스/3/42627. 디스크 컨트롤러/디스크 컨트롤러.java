import java.util.*;

class Solution {
    class Job{
        int number;
        int requestTime;
        int lastTime;
        Job(int number, int requestTime, int lastTime){
            this.number = number;
            this.requestTime = requestTime;
            this.lastTime = lastTime;
        }
    }
    public int solution(int[][] jobs) {
        PriorityQueue<Job> activeQ = new PriorityQueue<>((a,b)->{
            // 우선 순위: lastTime(asc), requestTime(asc), number(asc)
            if(a.lastTime!=b.lastTime){
                return Integer.compare(a.lastTime, b.lastTime);
            } else if(a.requestTime != b.requestTime){
                return Integer.compare(a.requestTime, b.requestTime);
            }else{
                return Integer.compare(a.number, b.number);
            }
        });
        
        // 전체 정렬을 한번만 하므로 PQ보다 array를 sorting하는게 낫다
        // 구현과정은 쉬우므로 PQ기반을 굳이 수정하지는 않음
        PriorityQueue<Job> deactiveQ = new PriorityQueue<>((a,b)->{
            return Integer.compare(a.requestTime, b.requestTime);
        });
        
        int sequence = 0;
        for(int job[]: jobs){
            int requestTime = job[0];
            int lastTime = job[1];
            deactiveQ.offer(new Job(sequence++, requestTime, lastTime));
        }
        
        int time=0;
        int sumOfReturnTime = 0;
        while(!deactiveQ.isEmpty() || !activeQ.isEmpty()){
            while(!deactiveQ.isEmpty() 
                  && deactiveQ.peek().requestTime <= time){
                activeQ.offer(deactiveQ.poll());
            }
            
            if(!activeQ.isEmpty()){
                Job curJob = activeQ.poll();
                int curRequestTime = curJob.requestTime;
                int curLastTime = curJob.lastTime;
                
                time+=curLastTime;
                sumOfReturnTime+=time-curRequestTime;
            }else{
                time=deactiveQ.peek().requestTime;   
            }
        }
        
        return sumOfReturnTime/jobs.length;
    }
}