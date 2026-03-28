import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int n = citations.length;
        
        // citations를 오름차순 정렬
        Arrays.sort(citations);
        
        // 이분탐색을 통해 lowerBound 찾기
        int low=0;
        int high=n;
        while(low<high){
            int i = low + (high-low)/2;
            if(citations[i]>=n-i){
                high=i;
            } else{
                low=i+1;
            }
        }
        // while문이 끝나면 low 또는 high가 조건을 만족한 i가 됨
        return n-high; // h값 리턴
    }
}