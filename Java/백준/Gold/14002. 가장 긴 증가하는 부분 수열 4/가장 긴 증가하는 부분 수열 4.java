import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] seq = new int[N];
        for(int i=0; i<N; i++){
            seq[i]= Integer.parseInt(st.nextToken());
        }

        int[] DP = new int[N];
        Arrays.fill(DP, 1);
        int maxLength=0;
        for(int i=0; i<N; i++){
            for(int j=0; j<i; j++){
                if(seq[i]>seq[j]){
                    DP[i]=Math.max(DP[i], DP[j]+1);
                }
            }
            maxLength=Math.max(maxLength, DP[i]);
        }

        Deque<Integer> stack = new ArrayDeque<>();
        int target=maxLength;
        for(int i=N-1; i>=0; i--){
            if(DP[i]==target){
                stack.push(i);
                target--;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(maxLength).append("\n");
        while(!stack.isEmpty()){
            sb.append(seq[stack.pop()]).append(" ");
        }
        sb.append("\n");


        System.out.print(sb.toString());
    }

}