import java.io.*;
import java.util.*;

public class Main {
    static int A;
    static int B;
    static int C;
    static long cal1;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        cal1 = A % C;
        // // 시간복잡도가 오래 걸리는 방식
        // long result = 1;
        // for(int i=0; i<B; i++){
        //     result = (result * A) % C;
        // }
        // System.out.println(result);
        System.out.println(cal(B));
    }

    private static long cal(int num){
        if(num==1){
            return cal1;
        }
        long result = 1;
        long buffer = cal(num/2);
        if(num%2==0){ // num is even
            result = (result * buffer) % C;
            result = (result * buffer) % C;
        } else{ // num is odd
            result = (result * cal1) % C;
            result = (result * buffer) % C;
            result = (result * buffer) % C;
        }
        return result;
    }
}