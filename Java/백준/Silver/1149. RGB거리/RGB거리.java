import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int[][] totals = new int[n+1][3];
        
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                int lastMin=Integer.MAX_VALUE;
                for(int k=0; k<3; k++){
                    if(k!=j){
                        lastMin = Math.min(lastMin, totals[i-1][k]);
                    }
                }
                totals[i][j] = Integer.parseInt(st.nextToken()) + lastMin;
            }
            //System.out.println(String.format("totals[%d]: %d %d %d", i, totals[i][0], totals[i][1], totals[i][2]));
        }

        int result = Math.min(totals[n][0], totals[n][1]);
        result = Math.min(result, totals[n][2]);
        System.out.println(result);
    }
}