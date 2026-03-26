import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        // System.out.println(Arrays.toString(citations));
        
        // LowerBound를 통해 문제 조건이 참에서 거짓으로 바뀌는 지점을 빠르게 찾아내기
        int low = 0;
        int high = citations.length; 
        while(low<high){
            int mid = low + (high-low)/2;
            if(citations.length - mid >= citations[mid]){
                low = mid+1;
            }else{
                high= mid;
            }
        }
        // low-1이 조건의 참을 충족하는 최대 인덱스
        // 개수를 구해야하므로 다음을 리턴
        return citations.length - low;
    }
}