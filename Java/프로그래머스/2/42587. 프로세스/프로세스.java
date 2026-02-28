import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int[] orderedPriorities = Arrays.stream(priorities).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
        int index = 0;
        
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i=0; i<priorities.length; i++){
            queue.offer(i);
        }
        
        while(!queue.isEmpty()){
            int pid = queue.poll();
            if(orderedPriorities[index]==priorities[pid]){
                index++;
                if(pid==location){
                    return index;
                }
            }else{
                queue.offer(pid);
            }
        }    
        
        return -1;
    }
}