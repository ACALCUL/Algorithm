import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int trucksWeight = 0; // Weight of trucks that crosses the bridge
        int[] startCrossingTime = new int[truck_weights.length]; // Time that the truck starts crossing the bridge
        Queue<Integer> crossingTrucks= new ArrayDeque<>();
        
        for(int i=0; i<truck_weights.length; i++){
            int truck_weight = truck_weights[i];
            while(trucksWeight+truck_weight > weight){ // while weight of trucks is bigger than max weight
                time = Math.max(time, startCrossingTime[crossingTrucks.peek()]+bridge_length);
                trucksWeight-=truck_weights[crossingTrucks.poll()]; 
            }
            crossingTrucks.offer(i);
            trucksWeight += truck_weight;
            startCrossingTime[i] = time++;
        }
        
        int finalTruck=-1;
        while(!crossingTrucks.isEmpty()){
            finalTruck = crossingTrucks.poll();
        }
        time=startCrossingTime[finalTruck]+bridge_length+1;
        
        return time;
    }
}