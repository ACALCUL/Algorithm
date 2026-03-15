import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        // low~high 중 n<=sigma(T/times[i])를 만족하는 T의 최솟값 구하기
        // -> 결정문제 -> LowerBound 구하기
        long low = 1;
        long high = 1;
        for(int i=0; i<times.length; i++){
            high = Math.max(high, times[i]);
        }
        high *= n;
        while(low<high){
            long mid = low+(high-low)/2;
            long finishedNum = 0;
            for(int i=0; i<times.length; i++){
                finishedNum +=mid/times[i];
            }
            // true인 조건: finishedNum >= n
            if(finishedNum < n){
                low =mid+1;
            }else{
                high = mid;
            }
        }
        return high;
    }
}