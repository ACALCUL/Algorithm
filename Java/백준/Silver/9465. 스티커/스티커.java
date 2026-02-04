import java.io.*;
import java.util.*;
public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i<n; i++){
            int width = Integer.parseInt(br.readLine());
            solve(width, br);
        }
        System.out.print(sb.toString());
    }
    private static void solve(int width, BufferedReader br) throws IOException{
        int[][] arr = new int[width][2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<width; i++){
            arr[i][0] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<width; i++){
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        if(width>1){
            arr[1][0] += arr[0][1];
            arr[1][1] += arr[0][0];
        }
        for(int i=2; i<width; i++){
            arr[i][0] += Math.max(arr[i-1][1], arr[i-2][1]);
            arr[i][1] += Math.max(arr[i-1][0], arr[i-2][0]);
        }
        sb.append(Math.max(arr[width-1][0], arr[width-1][1])).append("\n");
    }
}
