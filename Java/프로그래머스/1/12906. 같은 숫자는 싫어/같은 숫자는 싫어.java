import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> solList = new ArrayList<>();
        
        int pastNum = -1;
        for(int i=0; i<arr.length; i++){
            int curNum = arr[i];
            if(curNum != pastNum){
                solList.add(curNum);
            }
            pastNum = arr[i];
        }
        
        int[] sol = new int[solList.size()];
        for(int i=0; i<sol.length; i++){
            sol[i]=solList.get(i);
        }
        return sol;
    }
}