import java.io.*;
import java.util.*;

public class Main {
    private static void getDists(int n, int m, int[][] map, int[][] dists){
        // 방문했다면 map을 -2로 변경
        int start_x=0;
        int start_y=0;
        boolean stop = false;
        for(int i=0; (i<n)&!stop; i++){
            for(int j=0; j<m; j++){
                if(map[i][j]>1){
                    start_x=i;
                    start_y=j;
                    stop=true;
                    break;
                }
            }
        }
        //System.out.println(start_x +" "+ start_y);

        Queue<Integer> queue = new ArrayDeque<>();
        // 최적화를 위해 큐에 들어가는 숫자: current_x * m + current_y
        queue.offer(start_x*m + start_y);
        map[start_x][start_y] = -2;
        dists[start_x][start_y] = 0;

        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};

        while(!queue.isEmpty()){
            int num = queue.poll();
            int cur_x = num/m;
            int cur_y = num%m;
            int dist = dists[cur_x][cur_y];

            for(int i=0; i<4; i++){
                int next_x = cur_x+dx[i];
                int next_y = cur_y+dy[i];
                if((next_x>=0)&&(next_x<n)&&(next_y>=0)&&(next_y<m)&&(map[next_x][next_y]!=-2)){
                    if(map[next_x][next_y]==0){
                        map[next_x][next_y]=-2;
                    } else{ // 1일 경우
                        queue.offer(next_x*m+next_y);
                        map[next_x][next_y]= -2;
                        dists[next_x][next_y]=dist+1;
                    }
                    
                }
            }

        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if((dists[i][j]==0)&&(map[i][j]==1)){
                    dists[i][j]=-1;
                }
            }
        }

    }

    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        for(int i=0; i<n; i++){
            st= new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        int[][] dists = new int[n][m];
        getDists(n, m, map, dists);
        
        StringBuilder sb = new StringBuilder();
        //sb.append("\n");
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                sb.append(dists[i][j]).append(" ");
            }
            sb.setLength(sb.length()-1);
            sb.append("\n");
        }

        System.out.print(sb.toString());

    }
}