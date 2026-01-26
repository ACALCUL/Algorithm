import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[] values;
    static boolean[] visited;
    static int[] sequence;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st= new StringTokenizer(br.readLine());
        values = new int[N];
        visited = new boolean[N];
        sequence = new int[M];
        for(int i=0; i<N; i++){
            values[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(values);

        dfs(0);
        System.out.print(sb.toString());
    }

    private static void dfs(int depth){
        if(depth==M){ // 종료 조건
            for(int term: sequence){
                sb.append(term).append(" ");
            }
            sb.setLength(sb.length()-1);
            sb.append("\n");
            return;
        }

        for(int i=0; i<N; i++){
            if(!visited[i]){
                sequence[depth]=values[i];
                visited[i]=true;
                dfs(depth+1);
                visited[i]=false;
            }
        }

    }
}