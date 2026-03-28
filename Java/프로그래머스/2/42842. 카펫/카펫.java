import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        for(int i=1; i*i<=yellow; i++){
            if(yellow % i == 0){
                // yellow의 가로: width, 세로: heigth
                int width = yellow/i;
                // i*i<=yellow이므로, yellow/i가 항상 i보다 큼
                int height = i;
                
                // brown의 값과 같은지 검증
                if(brown == 2*(width+height)+4){
                    //brown의 가로, 세로 리턴
                    return new int[]{width+2, height+2};
                }
            }
        }
        
        return new int[]{0, 0};
    }
}