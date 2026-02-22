import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[M];
        solve(N, M, arr, 0, 1);
        System.out.print(sb.toString());
    }

    private static void solve(int N, int M, int[] arr, int depth, int start){
        if(depth == M){
            for(int value: arr){
                sb.append(value).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=start; i<=N; i++){
            arr[depth] = i;
            solve(N, M, arr, depth+1, i);
        }

    }
}