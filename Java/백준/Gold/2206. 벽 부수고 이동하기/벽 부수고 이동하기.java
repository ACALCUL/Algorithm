import java.io.*;
import java.util.*;

public class Main {
    private static class Node{
        int X;
        int Y;
        int dist;
        boolean isBroken;
        Node(int X, int Y, int dist, boolean isBroken){
            this.X = X;
            this.Y = Y;
            this.dist = dist;
            this.isBroken = isBroken;
        }
    }
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N+2][M+2];
        for(int i=0; i<M+2; i++){
            map[0][i]=-1;
            map[N+1][i]=-1;
        } // 테두리는 전부 -1
        for(int i=0; i<N+2; i++){
            map[i][0]=-1;
            map[i][M+1]=-1;
        }

        for(int i=1; i<=N; i++){
            String s = br.readLine();
            for(int j=1; j<=M; j++){
                map[i][j]=s.charAt(j-1)-'0';
            }
        }

        // for(int i=0; i<N+2; i++){
        //     for(int j=0; j<M+2; j++){
        //         System.out.print(map[i][j]+" ");
        //     }
        //     System.out.println();
        // }

        System.out.println(getMinDist(N, M, map));

    }
    
    private static int getMinDist(int N, int M, int[][] map){
        int[] dirX = {-1, 0, 1, 0};
        int[] dirY = {0, 1, 0, -1};
        
        int minDist = Integer.MAX_VALUE;
        boolean[][][] visited = new boolean[2][N+2][M+2];
        // visited는 상태를 담아야 한다 -> 벽을 부순 여부도 visited에 넣어야 한다.
        // 첫번째 인덱스가 0: 벽을 부수기 전, 1: 벽을 부순 후

        Queue<Node> queue = new ArrayDeque<>();
        // stack의 element: int X, int Y, int dist, boolean isBroken

        visited[0][1][1] = true;
        queue.offer(new Node(1,1,1, false));

        while(!queue.isEmpty()){
            Node curNode = queue.poll();
            int curIsBroken = curNode.isBroken? 1: 0;

            if(curNode.X == N && curNode.Y == M){ // BFS는 최초로 목적지에 도달했을 때 최단거리가 보장됨
                return curNode.dist;
            }

            for(int i=0; i<4; i++){
                int nxtX = curNode.X + dirX[i];
                int nxtY = curNode.Y + dirY[i];
                int nxtDist = curNode.dist + 1;
                int nxtValue = map[nxtX][nxtY];

                if(nxtValue == 0){
                    if(!visited[curIsBroken][nxtX][nxtY]){
                        visited[curIsBroken][nxtX][nxtY] = true;
                        queue.offer(new Node(nxtX, nxtY, nxtDist, curNode.isBroken));
                    }
                } else if(nxtValue == 1 && curNode.isBroken == false){
                    if(!visited[1][nxtX][nxtY]){
                        visited[1][nxtX][nxtY] = true;
                        queue.offer(new Node(nxtX, nxtY, nxtDist, true));
                }
                }
            }

        }

        return -1;
    }
    
}
