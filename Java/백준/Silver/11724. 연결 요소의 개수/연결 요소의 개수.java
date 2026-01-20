import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<Integer>());
        }
        for(int i=0; i<m; i++){
            st= new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());
            graph.get(v).add(u);
            graph.get(u).add(v);
        }

        // for(int i=0; i<=n; i++){
        //     System.out.println(graph.get(i));
        // }
        System.out.println(countConnect(n, graph));
    }

    private static int countConnect(int n, ArrayList<ArrayList<Integer>> graph){
        int count=0;
        boolean[] visited = new boolean[n+1];
        
        for(int i=1; i<=n; i++){
            if(!visited[i]){
                count++;
                bfs(i, graph, visited);
            }
        }
        return count;
    }

    private static void bfs(int start, ArrayList<ArrayList<Integer>> graph, boolean[] visited){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start]=true;
            

        while(!queue.isEmpty()){
            for(int next: graph.get(queue.poll())){
                if(!visited[next]){
                    queue.add(next);
                    visited[next]=true;
                }
            }
        }
    }

    
}