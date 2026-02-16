// Bellman-Ford ver. finding minus cycle
// 벨만 포드 및 음수 사이클 버전은 시간복잡도가 O(VE)이다.
import java.io.*;
import java.util.*;

public class Main {

    private static class Edge{
        int startV;
        int endV;
        int weight;
        Edge(int startV, int endV, int weight){
            this.startV = startV;
            this.endV = endV;
            this.weight = weight;
        }
    }

    static int maxNum=(int)Math.pow(10, 9);
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i=0; i<TC; i++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken()); // 양방향 엣지의 개수
            int W = Integer.parseInt(st.nextToken()); // 단방향 음수가중치 엣지의 개수
            Edge[] edges = new Edge[2*E+W];
            for(int j=0; j<2*E; j+=2){
                st = new StringTokenizer(br.readLine());
                int startV = Integer.parseInt(st.nextToken());
                int endV = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                edges[j] = new Edge(startV, endV, weight);
                edges[j+1] = new Edge(endV, startV, weight);
            }
            for(int j=2*E; j<2*E+W; j++){
                st = new StringTokenizer(br.readLine());
                int startV = Integer.parseInt(st.nextToken());
                int endV = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                edges[j] = new Edge(startV, endV, -weight);
            }

            // for(int j=0; j<2*E+W; j++){
            //     int startV = edges[j].startV;
            //     int endV = edges[j].endV;
            //     int weight = edges[j].weight;
            //     System.out.println(startV+" "+endV+" "+weight);
            // }
            
            System.out.println(RevisedBellmanFord(N, edges, 1));
        }

    }

    private static String RevisedBellmanFord(int N, Edge[] edges, int start){
        int[] dists = new int[N+1];
        Arrays.fill(dists, maxNum);
        dists[start]=0;

        for(int i=0; i<N-1; i++){ // N-1번만 반복하면 됨
            for(int j=0; j<edges.length; j++){
                Edge curEdge = edges[j];
                int startV = curEdge.startV;
                int endV = curEdge.endV;
                int weight = curEdge.weight;
                if(dists[endV] > dists[startV] + weight){ 
                    // 순정 벨만포드와 다르게 dists[startV]!=maxNum 조건이 빠짐
                    // 왜냐하면 start와 이어지지 않은 음수 사이클이 있을수도 있으므로
                    dists[endV] = dists[startV] + weight;
                }
                // 거리가 갱신된 것만 Queue에 넣는다면 SPFA 알고리즘 -> 벨만포드의 상위호환
            }
        }
        
        // 이론상 N-1번 했을 때 가중치 갱신이 끝나야함 
        // -> 같은 자리를 갔을 때 가중치가 음수다? -> 거리가 무한대의 음수로 발산
        // 따라서 N-1 이후에 최저값 갱신된다면? 음수 사이클 존재
        for(int j=0; j<edges.length; j++){
                Edge curEdge = edges[j];
                int startV = curEdge.startV;
                int endV = curEdge.endV;
                int weight = curEdge.weight;
                if(dists[endV] > dists[startV] + weight){ // 순정 벨만포드와 다르게 dists[startV]!=maxNum 조건이 빠짐
                    return "YES";
                }
            }
    

        return "NO";
    }
}