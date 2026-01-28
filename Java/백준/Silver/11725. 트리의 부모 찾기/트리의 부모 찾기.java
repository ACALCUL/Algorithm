import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<Integer>());
        }

        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int num1= Integer.parseInt(st.nextToken());
            int num2= Integer.parseInt(st.nextToken());
            graph.get(num1).add(num2);
            graph.get(num2).add(num1);
        }

        int[] parents = new int[N+1];
        bfs(N, graph, parents);

        StringBuilder sb = new StringBuilder();
        for(int i=2; i<=N; i++){
            sb.append(parents[i]).append("\n");
        }
        System.out.print(sb.toString());
    }

    private static void bfs(int N, ArrayList<ArrayList<Integer>> graph, int[] parents){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        parents[1]=1;
        while(!queue.isEmpty()){
            int parent = queue.poll();
            for(int child: graph.get(parent) ){
                if(parents[child]==0){
                    parents[child]=parent;
                    queue.offer(child);
                }
            }
        }

    }
}