// Dijkstra's Algorithm: 시간복잡도가 O(ElogV)로 작음, 다만 한 점에 대한 모든 점의 최단 거리만 계산
import java.io.*;
import java.util.*;

public class Main {
    private static class Edge{
        int vertex;
        int weight;
        Edge(int vertex, int weight){
            this.vertex = vertex;
            this.weight = weight;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken()); // (1<=V<=20000)
        int E = Integer.parseInt(st.nextToken()); // (1<= E <= 300000)
        int startV = Integer.parseInt(br.readLine()); // startV는 V의 원소
        int maxNum = 1000 * E + 1; // maxLength = maxWeight * maxEdgeNum

        List<List<Edge>> edges = new ArrayList<>();
        for(int i=0; i<V+1; i++){
            edges.add(new ArrayList<>());
        }

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int vertex1 = Integer.parseInt(st.nextToken());
            int vertex2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());            
            edges.get(vertex1).add(new Edge(vertex2, weight));    
        }

        StringBuilder sb = new StringBuilder();

        // // Print edges
        // for(int i=1; i<edges.size(); i++){
        //     sb.append(i).append(": ");
        //     for(Edge edge: edges.get(i)){
        //         sb.append(edge.vertex).append(",").append(edge.weight).append(" ");
        //     }
        //     sb.append("\n");
        // }

        int[] distances = new int[V+1];
        Arrays.fill(distances, maxNum);
        
        dijkstra(startV, edges, distances);

        for(int i =1; i<distances.length; i++){
            if(distances[i] < maxNum){
                sb.append(distances[i]);
            } else{
                sb.append("INF");
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }

    private static void dijkstra(int startV, List<List<Edge>> edges, int[] distances){
        

        PriorityQueue<Edge> pq = new PriorityQueue<>((a,b)->{
            return Integer.compare(a.weight, b.weight);
        });
        // PQ에는 최단 거리 후보들을 넣음

        distances[startV] = 0;
        pq.offer(new Edge(startV, distances[startV]));

        while(!pq.isEmpty()){
            Edge curEdge = pq.poll();
            int curV = curEdge.vertex; 
            int curW = curEdge.weight;
            // startV와 curV의 거리: CurW

            // pq에 의해 W가 낮은 것부터 탐색
            // 따라서 처음으로 V에 접근했을 때의 W가 최소Wv
            // 그 이후에 V에 접근했을 때는 실행 X -> W>distance[V]인 경우는 pruning
            if(curW > distances[curV]) continue;

            for(Edge nextEdge: edges.get(curEdge.vertex)){
                int nextV = nextEdge.vertex;
                int nextW = nextEdge.weight;
                if(distances[curV]+nextW < distances[nextV]){
                    distances[nextV] = distances[curV]+nextW;
                    // 출력이 필요하다면 parent[nextV]=curV; 
                    // 그 반대가 안되는 이유는 "모든 자식은 아버지가 한 명이지만, 아버지는 자식이 여러 명일 수 있기 때문이다."
                    pq.offer(new Edge(nextV, distances[nextV]));
                }
            }

        }
    }
    
}