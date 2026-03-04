import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int val: scoville){ pq.offer((long)val); }
        while(pq.peek() < K){
            if(pq.size()>1){
                pq.offer(pq.poll()+pq.poll()*2);
                answer++;
            } else{
                return -1;
            }
        }
        return answer;
    }
}