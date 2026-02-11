import java.io.*;
import java.util.*;

public class Main {
    private static class Node{
        List<Integer> adj = new ArrayList<>();
        List<Integer> weight = new ArrayList<>();
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
            st = new StringTokenizer(line);
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            nodes[parent].adj.add(child);
            nodes[parent].weight.add(weight);

            nodes[child].adj.add(parent);
            nodes[child].weight.add(weight);
        }

        // for(int i=1; i<=nodeNum; i++){ // for printing tree
        //     Node node = nodes[i];
        //     System.out.print("i:"+i+"-> ");
        //     for(int j=0; j<node.adj.size(); j++){
        //         System.out.print(node.adj.get(j)+","+node.weight.get(j)+" ");
        //     }
        //     System.out.println();
        // }

        int startIndex = findMaxWeight(nodes, nodeNum, 1)[1];
        // System.out.println(startIndex); // for checking startIndex

        // 아무 점과 제일 먼 노드는 지름의 두 끝 노드 중 하나
        // 왜냐하면 지름의 정의가 제일 먼 두 노드의 거리를 의미하고, 
        // 만약 특정 점에서 제일 먼 노드가 두 끝 노드 중 하나가 아니라면 그 노드가 이미 지름의 두 끝 노드 중 하나일 것이므로 모순
        System.out.println(findMaxWeight(nodes, nodeNum, startIndex)[0]);

    }

    private static int[] findMaxWeight(Node[] nodes, int nodeNum, int startIndex){
        if(nodeNum < 2){
            return new int[]{0, 0};
        }

        int maxWeight = 0; // startNode에서 제일 먼 Node까지의 weight
        int maxWeightIndex = 0; // result[1]: startNode에서 제일 먼 Node의 인덱스
        int[] weights= new int[nodeNum+1];
        boolean[] visited = new boolean[nodeNum+1];

        Deque<int[]> stack = new ArrayDeque<>();
        // stack에 들어갈 노드: (Index, depth, weight)
        stack.push(new int[]{startIndex, 0, 0});
        while(!stack.isEmpty()){
            int[] element = stack.pop();
            int curIndex = element[0];
            Node curNode = nodes[curIndex];
            int curDepth = element[1];
            int curWeight = element[2];

            visited[curIndex]= true;
            weights[curDepth]=curWeight;

            int sum = sumWeights(weights, curDepth);
            for(int i=0; i<curNode.adj.size(); i++){
                int nextIndex = curNode.adj.get(i);
                if(visited[nextIndex]) { continue; }
                int nextWeight = curNode.weight.get(i);

                if(sum+nextWeight > maxWeight){
                    maxWeight = sum+nextWeight;
                    maxWeightIndex = nextIndex;
                }

                stack.push(new int[]{nextIndex, curDepth+1, nextWeight});
                // System.out.println(String.format("put ( %d, %d, %d )",nextIndex, curDepth+1, nextWeight));
            }
            
        }

        return new int[]{maxWeight, maxWeightIndex};
    }

    private static int sumWeights(int[] weights, int index){ // index이하의 weights의 총합
        int sum = 0;
        for(int i=0; i<=index; i++){
            sum += weights[i];
        }
        return sum;
    }
}
