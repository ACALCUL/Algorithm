import java.io.*;
import java.util.*;

public class Main {
    // 1~N의 숫자 중 서로 다른 숫자 M개를 고른 수열을 오름차순으로 출력 + 순서가 달라도 중복으로 인정(조합)

    static int N;
    static int M;
    static int[] sequence;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 가능한 숫자의 범위: 1~N
        M = Integer.parseInt(st.nextToken()); // 선택할 숫자의 개수; M

        sequence = new int[M];
        sb = new StringBuilder();
        
        dfs(0, 1);
        System.out.print(sb.toString());
    }
    
    private static void dfs(int depth, int start){
        if(depth == M ){ // 종료 조건
            for(int val: sequence){
                sb.append(val).append(" ");
            }
            sb.setLength(sb.length()-1);
            sb.append("\n");
            return;
        }

        for(int i=start; i<=N; i++){
            sequence[depth]=i;
            dfs(depth+1, i+1); // start가 visited의 역할도 대신 해줌
        }

    }
}