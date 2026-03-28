import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        // yellow의 모든 width, height 경우의 수를 구하고
        // brown의 값에 맞으면 brown의 가로, 세로를 반환
        for(int i=1; i*i<=yellow; i++){
            if(yellow % i == 0){
                int width = Math.max(i, yellow/i);
                int height = Math.min(i, yellow/i);
                if(brown == 2*(width+height)+4){
                    return new int[]{width+2, height+2};
                }
            }
        }
        
        return new int[]{0, 0};
    }
}