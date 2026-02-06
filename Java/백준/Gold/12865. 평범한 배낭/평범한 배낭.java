import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()); // num of item
        int K = Integer.parseInt(st.nextToken()); // max weight

        int[] weights = new int[N+1];
        int[] values = new int[N+1];

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            weights[i] = Integer.parseInt(st.nextToken());
            values[i] = Integer.parseInt(st.nextToken());
        }

        int[][] DP = new int[N+1][K+1];
        // DP: row번째 item까지 사용했을 때, col이 max weight일 때의 max value

        
        for(int i=1; i<=N; i++){
            for(int j=1; j<=K; j++){
                if(j>=weights[i]){
                    DP[i][j] = Math.max(DP[i-1][j], DP[i-1][j-weights[i]]+values[i]);
                } else{
                    DP[i][j] = DP[i-1][j];
                }
            }
        }

        // for(int i = 0; i<=N; i++){ // For checking DP
        //     System.out.println(Arrays.toString(DP[i]));
        // }

        System.out.println(DP[N][K]);
    }
}
