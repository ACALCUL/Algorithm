import java.io.*;
import java.util.*;

public class Main {
    // 1~N의 숫자 중 서로 다른 숫자 M개를 고른 수열을 오름차순으로 출력
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 가능한 숫자의 범위: 1~N
        int M = Integer.parseInt(st.nextToken()); // 선택할 숫자의 개수; M

        boolean[] visited = new boolean[N+1];
        int[] sequence = new int[M];
        StringBuilder sb = new StringBuilder();
        
        dfs(0, N, M, visited, sequence, sb);
        System.out.print(sb.toString());
    }
    
    private static void dfs(int depth, int N, int M, boolean[] visited, int[] sequence, StringBuilder sb){
        if(depth == M ){ // 종료 조건
            for(int val: sequence){
                sb.append(val).append(" ");
            }
            sb.setLength(sb.length()-1);
            sb.append("\n");
            return;
        }

        for(int i=1; i<=N; i++){
            if(!visited[i]){
                visited[i]=true;
                sequence[depth]=i;
                dfs(depth+1, N, M, visited, sequence, sb);
                visited[i]=false;
            }
        }

    }
}