import java.io.*;
import java.util.*;
public class Main {
    private static class Field{
        int width;
        int length;
        int[][] map;
        static final int[] dx = {0, 0, -1, 1};
        static final int[] dy = {-1, 1, 0, 0};


        Field(int width, int length){
            this.width=width;
            this.length=length;
            this.map = new int[width][length];
        }

        int findBugNum(){
            int bugNum=0;
            for(int i=0; i<width; i++){
                for(int j=0; j<length; j++){
                    if(map[i][j]==1){
                        dfs(i, j);
                        bugNum++;
                    }
                }
            }

            return bugNum;
        }

        void dfs(int x, int y){
            map[x][y]=0;
            for(int i=0; i<4; i++){
                int next_x=x+dx[i];
                int next_y=y+dy[i];
                if((next_x<0)||(next_x>=width)||(next_y<0)||(next_y>=length)){ continue; }
                if(map[next_x][next_y]==1){
                    dfs(next_x, next_y);
                }
            }
        }

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<t; i++){

            st = new StringTokenizer(br.readLine());
            int width = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());
            int cabbageNum = Integer.parseInt(st.nextToken());
            Field field = new Field(width, length);

            for(int j=0; j<cabbageNum; j++){
                st= new StringTokenizer(br.readLine());
                field.map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]=1;
            }
            sb.append(field.findBugNum()).append("\n");
        }

        System.out.print(sb.toString());

    }
}