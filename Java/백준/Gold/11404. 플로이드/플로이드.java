import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int maxW;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        maxW = 100000*100+1;
        int[][] dists = new int[n+1][n+1];
        for(int i=0; i<=n; i++){
            Arrays.fill(dists[i], maxW);
            dists[i][i]=0;
        }

        StringTokenizer st;
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            dists[start][end] = Math.min(dists[start][end], weight);
        }
        // printMatrix(dists, n);
        // sb.append("\n");
        floyd(dists, n);
        printMatrix(dists, n);

        System.out.print(sb.toString());

    }
    private static void printMatrix(int[][] array, int n){ 
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(array[i][j] == maxW){
                    sb.append(0);
                } else{
                    sb.append(array[i][j]);
                }
                sb.append(" ");
            }
            sb.setLength(sb.length()-1);
            sb.append("\n");
        }
    }

    private static void floyd(int[][] dists, int n){
        for(int mid = 1; mid<=n; mid ++){
            for(int start=1; start<=n; start++){
                for(int end=1; end<=n; end++){
                    int curWeight = dists[start][mid] + dists[mid][end];
                    if(curWeight < dists[start][end]){
                        dists[start][end] = curWeight;
                    }
                }
            }
        }
    }
}
