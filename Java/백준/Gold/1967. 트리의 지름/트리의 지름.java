import java.io.*;
import java.util.*;

public class Main {
    private static class Node{
        List<int[]> edges = new ArrayList<>();
        // adjEdge는 (node, weight) 형태
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nodeNum = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[nodeNum+1];
        for(int i=1; i<nodeNum+1; i++){
            nodes[i] = new Node();
        }

        StringTokenizer st;
        String line;

        while((line=br.readLine()) != null){
            if(line.isEmpty()) break;
            st = new StringTokenizer(line);
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            nodes[parent].edges.add(new int[]{child, weight});
            nodes[child].edges.add(new int[]{parent, weight});
        }

        // for(int i=1; i<=nodeNum; i++){ // for printing tree
        //     Node node = nodes[i];
        //     System.out.print("node: "+i+"-> ");
        //     for(int[] edge: node.edges){
        //         System.out.print(edge[0]+","+edge[1]+" ");
        //     }
        //     System.out.println();
        // }

        int startIndex = findMaxWeight(nodes, nodeNum, 1)[1];

        // 아무 점과 제일 먼 노드는 지름의 두 끝 노드 중 하나
        // 왜냐하면 지름의 정의가 제일 먼 두 노드의 거리를 의미하고, 
        // 만약 특정 점에서 제일 먼 노드가 두 끝 노드 중 하나가 아니라면 그 노드가 이미 지름의 두 끝 노드 중 하나일 것이므로 모순
        System.out.println(findMaxWeight(nodes, nodeNum, startIndex)[0]);

    }

    private static int[] findMaxWeight(Node[] nodes, int nodeNum, int startIndex){
        //System.out.println("\nstartIndex: "+startIndex);
        int maxWeight = 0; // startNode에서 제일 먼 Node까지의 weight
        int maxWeightIndex = startIndex; // startNode에서 제일 먼 Node의 인덱스
        boolean[] visited = new boolean[nodeNum+1];

        Deque<int[]> stack = new ArrayDeque<>();
        // stack에 들어갈 노드: (Index, weight)
        stack.push(new int[]{startIndex, 0});
        visited[startIndex] = true;

        while(!stack.isEmpty()){
            int[] element = stack.pop();
            int curIndex = element[0];
            int curWeight = element[1];

            for(int[] edge: nodes[curIndex].edges){
                int nextIndex = edge[0];
                if(visited[nextIndex]) { continue; }
                int nextWeight = curWeight + edge[1];

                if(nextWeight > maxWeight){
                    maxWeight = nextWeight;
                    maxWeightIndex = nextIndex;
                }

                stack.push(new int[]{nextIndex, nextWeight});
                visited[nextIndex]=true;
                //System.out.println(String.format("put ( %d, %d )", nextIndex, nextWeight));
            }
            
        }

        return new int[]{maxWeight, maxWeightIndex};
    }

}
