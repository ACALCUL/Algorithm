// 0-1 BFS 풀이 방법: 가중치가 2개 일때만 작동(왜냐하면 addFirst, addLast로 차등을 주는 방식이므로)
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        System.out.println(getMin(start, end));
    }

    private static int getMin(int start, int end){
        if(start>=end) return start-end; // start가 end보다 클 때의 예외 처리 

        int maxNum = 100000;
        int distances[] = new int[maxNum+1];
        Arrays.fill(distances, -1);
        
        Deque<Integer> deque = new ArrayDeque<Integer>();
        distances[start]= 0;
        deque.offer(start);

        while(!deque.isEmpty()){
            int curNum = deque.poll();
            if(curNum == end) break; // 종료 조건
            int curDistance = distances[curNum];

            // 1. 시간이 0인 경우: curNum*2
            int nextNum1 = curNum*2;
            if(nextNum1<=maxNum){
                if(distances[nextNum1]==-1 || distances[nextNum1] > curDistance){
                    distances[nextNum1] = curDistance;
                    deque.addFirst(nextNum1); 
                }
            }

            // 2. 시간이 1인 경우: curNum+1, curNum-1
            int[] nextNums = {curNum+1, curNum-1};
            for(int nextNum : nextNums){
                if(nextNum >=0 && nextNum<=maxNum){
                    if(distances[nextNum]==-1 || distances[nextNum] > curDistance+1){
                        distances[nextNum] = curDistance+1;
                        deque.addLast(nextNum);
                    }
                }
            }

        }

        return distances[end];
    }
}
