import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> map = new HashSet<>();
        for(int num: nums){
            map.add(num);
        }
        
        int len = nums.length;
        int answer = len/2>map.size()? map.size(): len/2;
        return answer;
    }
}