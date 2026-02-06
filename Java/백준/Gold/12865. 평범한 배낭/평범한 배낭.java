import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dp = new int[K+1];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            for(int j=K; j>=weight; j--){ 
                // 순방향으로 할 경우 현재 item을 반영한 dp를 사용함 -> 현재 item 중복 사용 가능
                 dp[j]=Math.max(dp[j], dp[j-weight]+value);
            }
        }

        System.out.println(dp[K]);
    }
}