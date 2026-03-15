import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<Integer>());
        }
        for(int i=0; i<edge.length; i++){
            int v1 = edge[i][0];
            int v2 = edge[i][1];
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }
        
        return getLongestNodeNum(n, graph);
    }
    class Node{
        int vertex;
        int depth;
        Node(int vertex, int depth){
            this.vertex = vertex;
            this.depth = depth;
        }
    }
    
    private int getLongestNodeNum(int n, List<List<Integer>> graph){
        int maxDepth = 0;
        int count = 1;
        boolean[] visited = new boolean[n+1]; 
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(1, 0));
        visited[1]=true;
        while(!queue.isEmpty()){
            Node curNode = queue.poll();
            int curV = curNode.vertex;
            int curD = curNode.depth;
            
            if(curD > maxDepth){
                maxDepth = curD;
                count = 1;
            }else{
                count++;
            }
            // System.out.printf("curV: %d, curD: %d, count: %d\n", curV, curD, count);
            
            for(int nextV: graph.get(curV)){
                if(!visited[nextV]){
                    queue.offer(new Node(nextV, curD+1));
                    visited[nextV]=true;   
                }
            }
            
        }
        return count;
    }
}