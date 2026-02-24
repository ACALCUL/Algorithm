import java.util.*;
// HashSet을 통해 하위범주가 있는지 여부를 체크하는 참신한 방법

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        HashSet<String> hashSet = new HashSet<>();
        
        for(String num: phone_book){
            hashSet.add(num);
        }
        
        for(String num: phone_book){
            for(int i=0; i<num.length()-1; i++){
                String subNum = num.substring(0, i+1);
                if(hashSet.contains(subNum)){
                    return false;
                }
            }
        }
        
        return answer;
    }
}