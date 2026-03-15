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
    
    private int getLongestNodeNum(int n, List<List<Integer>> graph){
        // Node 객체를 만드는 것보다 int[] 배열을 만드는 것이 효율적
        int count = 0;
        int maxDepth = 0;
        int[] dist = new int[n+1];
        boolean[] visited = new boolean[n+1]; 
        Queue<Integer> queue = new ArrayDeque<>();
        
        queue.offer(1);
        visited[1]=true;
        dist[1]=0;
        
        while(!queue.isEmpty()){
            int curV = queue.poll();
            int curD = dist[curV];
            if(maxDepth < curD){
                maxDepth = curD;
                count = 1;
            }else{
                count++;
            }
            
            for(int nextV: graph.get(curV)){
                if(!visited[nextV]){
                    queue.offer(nextV);
                    visited[nextV]=true;  
                    dist[nextV] = curD + 1;
                }
            }
        }
        
        return count;
    }
}