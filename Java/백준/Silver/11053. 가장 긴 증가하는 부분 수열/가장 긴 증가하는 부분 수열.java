import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] seq;
    static int[] DP;
    static int maxLength=0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        seq = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            seq[i]=Integer.parseInt(st.nextToken());
        }

        DP = new int[N];
        Arrays.fill(DP, 1);

        for(int i=0; i<N; i++){
            for(int j=0; j<i; j++){
                if(seq[i]>seq[j]){
                    DP[i]=Math.max(DP[i], DP[j]+1);
                }
            }
            maxLength=Math.max(maxLength, DP[i]);
        }
        //System.out.println(Arrays.toString(DP));
        System.out.println(maxLength);

    }
}