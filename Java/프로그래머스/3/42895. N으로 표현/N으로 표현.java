import java.util.*;

class Solution {
    public int solution(int N, int number) {
        // 제네릭 배열보다 제네릭을 제네릭 안에 감싸는게 자바에 적절
        List<HashSet<Integer>> counts = new ArrayList<>();
        // 1부터 8까지 필요
        // count가 i인 원소들이 counts의 i번째 HashSet에 존재
        
        int startNum = 0;
        counts.add(new HashSet<Integer>());
        for(int i=1; i<=8; i++){ 
            counts.add(new HashSet<Integer>());
            startNum = 10*startNum + N;
            counts.get(i).add(startNum);
            if(startNum == number){ return i; }
        } 
        for(int i=2; i<=8; i++){
            for(int j=1; j<i; j++){
                // counts.get(j)의 모든 원소와 counts.get(i-j)의 모든 원소에 대해 사칙연산(+, -, *, /을 수행
                // val이 1보다 작으면 무시, number이면 i리턴 아니면 list.get(i) 배열에 저장
                for(int val1: counts.get(j)){
                    for(int val2: counts.get(i-j)){
                            counts.get(i).add(val1+val2);
                            counts.get(i).add(val1-val2);
                            counts.get(i).add(val1*val2);
                            if(val2 != 0){
                                counts.get(i).add(val1/val2);
                            }
                    }
                }
                if(counts.get(i).contains(number)){
                    return i;
                }
            }
        }
        return -1;
    }
}