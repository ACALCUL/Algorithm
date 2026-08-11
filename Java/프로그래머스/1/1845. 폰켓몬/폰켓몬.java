import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> map = new HashSet<>();
        for(int num: nums){
            map.add(num);
        }
        
        int cnt = 0;
        for(int num: map){
            cnt++;
        }
        
        int len = nums.length;
        int answer = len/2>cnt? cnt: len/2;
        return answer;
    }
}