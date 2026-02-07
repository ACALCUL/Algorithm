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
        int maxNum = 100000;
        int distances[] = new int[maxNum+1];
        Arrays.fill(distances, maxNum+1);
        
        Queue<Integer> queue = new ArrayDeque<Integer>();
        distances[start]= 0;
        queue.offer(start);
        while(!queue.isEmpty()){
            int curNum = queue.poll();
            int curDistance = distances[curNum];
            int nextNums[] = {curNum+1, curNum-1, 2*curNum};
            // System.out.println("curNum: "+curNum+"\nnextNums: "+Arrays.toString(nextNums));
            for(int i=0; i<3; i++){
                int nextNum = nextNums[i];
                if(nextNum<0 || nextNum>maxNum){ // 범위가 넘어설 경우 이번 루프 뛰어넘기
                    continue;
                }
                if(distances[nextNum] == maxNum+1){ // 무한루프 방지를 위해 queue에 들어갔던 num은 제외
                    queue.offer(nextNum);
                }

                if(i == 2){
                    distances[nextNum] = Math.min(distances[nextNum], curDistance);
                }else{
                    distances[nextNum] = Math.min(distances[nextNum], curDistance+1);
                }

                // System.out.println("\tnextNum: "+nextNum+"\n\tdistance: "+distances[nextNum]);
            }

        }

        return distances[end];
    }
}