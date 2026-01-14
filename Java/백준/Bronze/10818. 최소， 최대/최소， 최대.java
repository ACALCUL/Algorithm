import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int maxNum=-1000000;
        int minNum=1000000;
        int num;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            num = Integer.parseInt(st.nextToken());
            minNum=(num<minNum)?num:minNum;
            maxNum=(num>maxNum)?num:maxNum;
        }
        System.out.println(String.format("%d %d", minNum, maxNum));
    }
}
