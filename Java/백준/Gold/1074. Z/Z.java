import java.io.*;
import java.util.*;

// 하나하나 기록하는 방식은 시간, 공간이 너무 많이 소요됨 -> 바로 바로 값 기록하며 찾아가기

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.println(getCount(N, r, c));
    }   
    private static int getCount(int N, int r, int c){
        int size = (int) Math.pow(2, N);
        if((r>=size)||(c>=size)){ return -1;}
        int cur_x = 0;
        int cur_y = 0;
        int cur_count = 0;
        int[] dx = {0, 0, 1, 1};
        int[] dy = {0, 1, 0, 1};

        while(size>1){
            size /= 2; // size는 무조건 절반으로 감소

            for(int i=0; i<4; i++){
                int next_x = cur_x + size * dx[i];
                int next_y = cur_y + size * dy[i];
                int next_count = cur_count + i*size*size;

                if((r==next_x)&&(c==next_y)){
                        return next_count;
                }

                if((r>=next_x)&&(r<next_x+size)&&(c>=next_y)&&(c<next_y+size)){
                    cur_x = next_x;
                    cur_y = next_y;
                    cur_count = next_count;
                    break;
                } 

            }

        }

        // 있을 수 없는 리턴값
        return -2;

    }

}