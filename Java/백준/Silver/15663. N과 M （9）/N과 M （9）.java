import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[] seq;
    static boolean[] visited;
    static int[] sameNum;
    static int[] mySeq;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        seq = new int[N];
        for(int i=0; i<N; i++){
            seq[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(seq);
        //sb.append(Arrays.toString(seq)).append("\n"); // for check

        sameNum = new int[N];
        visited = new boolean[N];
        for(int i = N-1; i>0; i--){
            if(seq[i]==seq[i-1]){
                sameNum[i-1]= sameNum[i]+1;
                visited[i]=true;
            }
        }
        //sb.append(Arrays.toString(sameNum)).append("\n"); // for check
        mySeq = new int[M];
        dfs(0);

        System.out.print(sb.toString());
    } 
    
    static private void dfs(int depth){
        if(depth==M){
            for(int term: mySeq){
                sb.append(term).append(" ");
            }
            sb.setLength(sb.length());
            sb.append("\n");
            return;
        }

        for(int i=0; i<N; i++){
            if(!visited[i]){
                if(sameNum[i]>0){
                    for(int j=1; j<=sameNum[i]; j++){
                        visited[i+j]=false;
                    }
                }
                mySeq[depth]=seq[i];
                visited[i]=true;
                dfs(depth+1);
                visited[i]=false;
                for(int j=1; j<=sameNum[i]; j++){
                        visited[i+j]=true;
                }
            }
        }
    }
}