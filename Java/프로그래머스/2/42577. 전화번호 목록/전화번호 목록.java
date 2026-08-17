import java.util.*;

class Solution{
    public boolean solution(String[] phone_book){
        boolean answer = true;
        
        Arrays.sort(phone_book, Comparator.naturalOrder());
        HashSet<String> set = new HashSet<>();
        
        for(String phone: phone_book){
            for(int i=0; i<phone.length(); i++){
                if(set.contains(phone.substring(0,i)))
                    return false;
            }
            set.add(phone);
        }
        
        return answer;   
    }
}