import java.io.*;
import java.util.*;

public class Main {
    static int maxNum;

    private static class Node{
        int vertex;
        int weight;
        Node(int vertex, int weight){
            this.vertex = vertex;
            this.weight = weight;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        maxNum = 100 * N + 1;

        List<List<Node>> graph = new ArrayList<>();
        List<List<Node>> graphReverse = new ArrayList<>();
        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<>());
            graphReverse.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph.get(start).add(new Node(end, weight));
            graphReverse.get(end).add(new Node(start, weight));
        }

        int[] dists = new int[N+1];
        dijkstra(graph, X, dists); // X -> 모든 점 까지의 최단경로
        // System.out.println("dists: "+ Arrays.toString(dists));
        int[] distsReverse = new int[N+1];
        dijkstra(graphReverse, X, distsReverse); // 모든 점 -> X 까지의 최단경로
        // System.out.println("distsReverse: "+Arrays.toString(distsReverse));

        int maxTime = 0;
        for(int i=1; i<=N; i++){
            maxTime = Math.max(maxTime, dists[i]+distsReverse[i]);
        }
        
        System.out.println(maxTime);
    }

    private static void dijkstra(List<List<Node>> graph, int X, int[] dists){
        PriorityQueue<Node> PQ = new PriorityQueue<>((a,b)->{
            return Integer.compare(a.weight, b.weight);
        });

        Arrays.fill(dists, maxNum);

        dists[X]=0;
        PQ.offer(new Node(X, dists[X]));

        while(!PQ.isEmpty()){
            Node curNode = PQ.poll();
            int curV = curNode.vertex;
            int curW = curNode.weight;

            if(curW>dists[curV]) continue;

            // System.out.println(String.format("\nCurV: %d, CurW: %d", curV, curW));
            for(Node nxtNode: graph.get(curV)){
                int nxtV = nxtNode.vertex;
                int nxtW = nxtNode.weight;
                // System.out.println(String.format("nxtV: %d, nxtW: %d", nxtV, nxtW));
                if(dists[nxtV]>dists[curV]+nxtW){
                    dists[nxtV] = dists[curV] + nxtW;
                    // System.out.println(String.format("dists[%d]를 %d로 갱신", nxtV, dists[nxtV]));
                    PQ.offer(new Node(nxtV, dists[nxtV]));
                }
            }
        }
    }
}