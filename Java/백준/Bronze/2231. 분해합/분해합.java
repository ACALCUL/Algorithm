import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int numDigit=0;
        int targetNum=0;

        for(int i=1; n/i!=0; i*=10){
            numDigit++;
        }
        // System.out.println(numDigit);

        for(int i=n-9*numDigit; i<=n; i++){
            // System.out.println("i: "+ i);
            int count = i;
            int k= 10;
            for(int j=0; j<numDigit; j++){
                int digitNum = i%k/(k/10);
                // System.out.println(digitNum);
                count+=digitNum;
                k*=10;
            }
            // sSystem.out.println("count: "+count);
            if(count == n){
                targetNum = i;
                break;
            }
        }
        System.out.println(targetNum);
        
    }
}