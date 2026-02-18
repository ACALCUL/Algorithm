import java.io.*;
import java.util.*;

public class Main {
    private static class Node{
        int vertex;
        int weight;
        Node(int vertex, int weight){
            this.vertex = vertex;
            this.weight = weight;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());
        List<List<Node>> adjNodes = new ArrayList<>();
        for(int i=0; i<=V; i++){
            adjNodes.add(new ArrayList<>());
        }
        StringTokenizer st;
        for(int i=0; i<V; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            while(true){
                int end = Integer.parseInt(st.nextToken());
                if(end == -1){ break; }
                int weight = Integer.parseInt(st.nextToken());
                adjNodes.get(start).add(new Node(end, weight));
            }
        }

        // for(int i=1; i<=V; i++){ // for checking 'adjNodes'
        //     System.out.print(i+": ");
        //     for(Node node: adjNodes.get(i)){
        //         System.out.print(node.vertex+","+node.weight+" ");
        //     }
        //     System.out.println();
        // }

        int startVertex = getMaxWeight(1, V, adjNodes)[1];
        System.out.println(getMaxWeight(startVertex, V, adjNodes)[0]);

    }

    private static int[] getMaxWeight(int startVertex, int V, List<List<Node>> adjNodes){
        int maxWeight = 0;
        int maxWeightVertex = 0;
        boolean[] visited = new boolean[V+1];
        
        Queue<Node> queue = new ArrayDeque<>();
        // Node: vertex, weight(weight to startVertex)
        queue.offer(new Node(startVertex, 0));
        visited[startVertex] = true;
        while(!queue.isEmpty()){
            Node curNode = queue.poll();
            int curVertex = curNode.vertex;
            int curWeight = curNode.weight;

            if(curWeight > maxWeight){
                maxWeight = curWeight;
                maxWeightVertex = curVertex;
            }

            for(Node nxtNode: adjNodes.get(curVertex)){
                int nxtVertex = nxtNode.vertex;
                if(visited[nxtVertex]){ continue; }
                int nxtWeight = curNode.weight + nxtNode.weight;
                queue.offer(new Node(nxtVertex, nxtWeight));
                visited[nxtVertex] = true;
            }
        }

        return new int[]{maxWeight, maxWeightVertex};
    }

}