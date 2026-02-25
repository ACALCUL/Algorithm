import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> typeIdToNum = new HashMap<>();
        for(String[] element: clothes){
            String type = element[1];
            typeIdToNum.merge(type, 1, Integer::sum);
        }
        // merge 메소드란?
        // 첫번째 인자: myKey, 두 번째 인자: myValue, 세번째 인자: remapping function
        // myKey가 HashMap에 없다면, (myKey, myValue)를 집어넣는다
        // myKey가 HashMap에 있다면, 기존 value와 myValue를 각각 1, 2번째 인자로 지정한 remapping function의 반환값을 myKey의 value로 대체한다.
            
        // Integer::sum의 의미:
        // (a, b) -> Integer.sum(a,b);
        
        int answer = 1;
        for(String type: typeIdToNum.keySet()){
            answer*=typeIdToNum.get(type)+1;
        }
        
        return --answer;
    }
}