import java.util.*;

class Solution{
    public int solution(String[][] clothes){
        HashMap<String, Integer> map = new HashMap<>();
        for(String[] clothe: clothes){
            map.put(clothe[1], map.getOrDefault(clothe[1], 0)+1);
        }
        
        int num=1;
        for(int value: map.values()){
            System.out.println(value);
            num*=value+1;
        }
        
        return --num;
    }
}