import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        Integer[] modifiedNumbers = new Integer[numbers.length];
        for(int i=0; i<numbers.length; i++){
            modifiedNumbers[i] = numbers[i];
        }
        
        Arrays.sort(modifiedNumbers, (a, b) -> {
            String valA = String.valueOf(a) + String.valueOf(b);
            String valB = String.valueOf(b) + String.valueOf(a);
            return valB.compareTo(valA); // 사전순으로 내림차순
        });
        
        StringBuilder sb = new StringBuilder();
        if(modifiedNumbers[0] == 0){ 
            // 0은 맨 뒤일 수 밖에 없는데 이게 첫번째면 0으로만 이루어진 배열
            return "0";
        }
        for(int number: modifiedNumbers){
            sb.append(number);
        }
        String answer = sb.toString();
        return answer;
    }
    
}