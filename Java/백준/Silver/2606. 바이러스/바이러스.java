import java.io.*;
import java.util.*;

public class Main {
    private static void dfs(int i, List<List<Integer>> graph, boolean[] visited){
        visited[i]=true;
        for(int next: graph.get(i)){
            if(!visited[next]){
                dfs(next, graph, visited);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int edgeNum=Integer.parseInt(br.readLine());
        List<List<Integer>> graph= new ArrayList<>(n+1);

        for(int i=0; i<n+1; i++){
            graph.add(new ArrayList<Integer>());
        }

        StringTokenizer st;
        for(int i=0; i<edgeNum; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        // // print graph
        // for(int i=0; i<n+1; i++){
        //     System.out.println(graph.get(i));
        // }

        boolean[] visited = new boolean[n+1]; // boolean 배열 크기 지정 시 false로 초기화
        dfs(1, graph, visited);
        
        int cnt=0;
        for(int i=2; i<n+1; i++){
            if(visited[i]){ 
                //System.out.println(i);
                cnt++;
            }
        }
        System.out.println(cnt);
    }

}