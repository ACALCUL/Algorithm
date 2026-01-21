import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        System.out.println(getMin(n, k));
    }

    private static int getMin(int n, int k){
        int max_num= 100000;

        int[] distances = new int[max_num+1];
        Arrays.fill(distances, -1);
        // 인덱스: 숫자, 값: 숫자와 n의 거리(방문하지 않았을 시 -1)

        Queue<Integer> queue = new ArrayDeque<Integer>();
        queue.offer(n);
        distances[n]=0;

        while(!queue.isEmpty()){
            int num = queue.poll();
            int distance = distances[num];
            if(num==k){ return distance; }

            int[] nextNodes = {num-1, num+1, num*2};
            for(int next: nextNodes){
                if((next>=0)&&(next<=max_num)&&(distances[next]==-1)){
                    queue.offer(next);
                    distances[next]=distance+1;
                }
            }

        }

        return -1;
    }
}