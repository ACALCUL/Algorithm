import java.io.*;
import java.util.*;

public class Main {
    static int whiteNum=0;
    static int blueNum=0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] matrix = new int[n][n];
        StringTokenizer st;
        for(int i=0; i<n; i++){
            st= new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                matrix[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        // for(int i=0; i<n; i++){
        //     System.out.println(Arrays.toString(matrix[i]));
        // }

        getNum(0, 0, n, matrix);
        System.out.println(whiteNum);
        System.out.println(blueNum);
    }

    static void getNum(int start_x, int start_y, int size, int[][] matrix){
        if(size<2){ // 종료 조건: size가 1
            if(matrix[start_x][start_y]==0){
                whiteNum++;
            } else{
                blueNum++;
            }
            return;
        }

        int whiteCount=0;
        for(int i= start_x; i<start_x+size; i++){
            for(int j= start_y; j<start_y+size; j++){
                if(matrix[i][j]==0){
                    whiteCount++;
                }
            }
        }

        if(whiteCount==size*size){ // 전부 white인 경우
            whiteNum++;
            return;
        }
        if(whiteCount==0){ // 전부 Blue인 경우
            blueNum++;
            return;
        }

        // 분할 조건: 전부 Blue 혹은 White가 아닌 경우
        getNum(start_x, start_y, size/2, matrix);
        getNum(start_x+size/2, start_y, size/2, matrix);
        getNum(start_x, start_y+size/2, size/2, matrix);
        getNum(start_x+size/2, start_y+size/2, size/2, matrix);

    }
}