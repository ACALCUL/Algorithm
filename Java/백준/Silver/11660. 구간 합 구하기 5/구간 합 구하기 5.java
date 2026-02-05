import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // print2DArray(arr, N+1); // for checking arr

        int[][] DP = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            int sumOfCurRow = 0;
            for(int j=1; j<=N; j++){
                sumOfCurRow += arr[i][j];
                DP[i][j]=DP[i-1][j]+sumOfCurRow;
            }
        }

        //print2DArray(DP, N+1); // for checking DP

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            sb.append(DP[x2][y2] - DP[x2][y1-1] - DP[x1-1][y2] + DP[x1-1][y1-1]).append("\n");
        }
        System.out.print(sb.toString());

    }
    private static void print2DArray(int[][] arr, int size){
        System.out.println();
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                System.out.print(arr[i][j]+" ");             
            }
            System.out.println();
        }
    }
    
}
