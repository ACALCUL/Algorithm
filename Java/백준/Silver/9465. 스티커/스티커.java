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
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int secondLastNum1 = 0;
        int secondLastNum2 = 0;
        int firstLastNum1 = 0;
        int firstLastNum2 = 0;
        int curNum1 = 0;
        int curNum2 = 0;

        for(int i=0; i<width; i++){
            curNum1 = Integer.parseInt(st1.nextToken()) + Math.max(secondLastNum2, firstLastNum2);
            curNum2 = Integer.parseInt(st2.nextToken()) + Math.max(secondLastNum1, firstLastNum1);
            secondLastNum1 = firstLastNum1;
            secondLastNum2 = firstLastNum2;
            firstLastNum1 = curNum1;
            firstLastNum2 = curNum2;
        }
        sb.append(Math.max(firstLastNum1, firstLastNum2)).append("\n");
    }
}