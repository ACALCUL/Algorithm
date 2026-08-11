import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String, Integer> map = new HashMap<>();
        for(String person: participant){ map.put(person, map.getOrDefault(person, 0)+1); }
        // for(String key: map.keySet()){ System.out.println("key: "+key+" value:"+map.get(key)); }
        for(String person: completion){ map.put(person, map.getOrDefault(person, 0)-1); }
        
        // for(String key: map.keySet()){
        //     if(map.get(key)!=0){
        //         answer=key;
        //     }
        // }
        
        for(Map.Entry<String,Integer> entry: map.entrySet()){
            if(entry.getValue()!=0){
                answer= entry.getKey();
            }
        }
        
        
        return answer;
    }
}