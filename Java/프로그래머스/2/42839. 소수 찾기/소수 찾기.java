import java.util.*;

class Solution {
    
    public int solution(String numbers) {
        HashSet<Integer> set = new HashSet<>();
        boolean[] visited = new boolean[numbers.length()];
        getResultNum(numbers, set, visited, "");
        
        int answer = 0;
        for(int num: set){
            if(isPrime(num)){ answer++; }
        }
        return answer;
    }
    
    private void getResultNum(String numbers, HashSet<Integer> set, boolean[] visited, String resultNum){
        if(!resultNum.equals("")){
            set.add(Integer.parseInt(resultNum));
        }
        
        for(int i=0; i<numbers.length(); i++){
            if(!visited[i]){
                visited[i]= true;
                getResultNum(numbers, set, visited, resultNum+numbers.charAt(i));
                visited[i]= false;
            }
            
        }
    }
    
    private boolean isPrime(int num){
        if(num==2){ return true; }
        if(num<2 || num%2 == 0){ return false; }
        for(int i=3; i*i<=num; i+=2){
            if(num%i==0){ return false; }
        }
        return true;
    }
}