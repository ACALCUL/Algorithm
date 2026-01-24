import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int colNum = Integer.parseInt(st.nextToken()); // 문제에서 토마토 상자의 가로 칸의 수(M)
        int rowNum = Integer.parseInt(st.nextToken()); // 문제에서 토마토 상자의 세로 칸의 수(N)
        
        int[] matrix = new int[colNum*rowNum];
        boolean[] visited = new boolean[colNum*rowNum];
        Queue<int[]> queue = new ArrayDeque<>(); // int[]: (int index, int day)
        int zeroCount=0;

        for(int i=0; i<rowNum; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<colNum; j++){
                int index = colNum*i+j;
                matrix[index]= Integer.parseInt(st.nextToken());
                // matrix[index]의 경우의 수: -1, 0, 1
                switch(matrix[index]){
                    case -1:
                        visited[index]= true;
                        break;
                    case 1:
                        queue.offer(new int[]{index, 0}); 
                        visited[index]= true;
                        break;
                    case 0:
                        zeroCount++;
                } 
                
            }
        }
        System.out.println(solve(colNum, rowNum, matrix, visited, queue, zeroCount));

        // // 배열 확인용
        // for(int i=0; i<rowNum; i++){
        //     for(int j=0; j<colNum; j++){
        //         System.out.print(visited[colNum*i+j]+" ");
        //     }
        //     System.out.println();
        // }
    }

    private static int solve(int colNum, int rowNum, int[] matrix, boolean[] visited, Queue<int[]> queue, int zeroCount){
        // 0이 존재하지 않는 경우
        if(zeroCount<1){ return 0; }
        
        int maxDay=0;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while(!queue.isEmpty()){
            int[] curElement = queue.poll();
            int curIndex = curElement[0]; // curIndex = curX * colNum + curY;
            int curX = curIndex/colNum;
            int curY = curIndex%colNum;
            int curDay = curElement[1];

            for(int i=0; i<4; i++){
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                int nextIndex = nextX * colNum + nextY;
                if((nextX>=0)&&(nextX<rowNum)&&(nextY>=0)&&(nextY<colNum)&&(!visited[nextIndex])){
                    queue.offer(new int[]{nextIndex, curDay+1});
                    maxDay = Math.max(maxDay, curDay+1);
                    visited[nextIndex]=true;
                }
            }
        }
        
        for(int i=0; i<colNum * rowNum; i++){
            if(!visited[i]){
                return -1;
            }
        }

        return maxDay;
    }
}