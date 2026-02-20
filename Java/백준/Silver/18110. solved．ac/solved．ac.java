import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        if(n==0) {
            System.out.println(0); 
            return;
        }

        int[] values = new int[n];
        for(int i=0; i<n; i++){
            values[i]=Integer.parseInt(br.readLine());
        }
        Arrays.sort(values);
        // System.out.println(Arrays.toString(values));

        int removeNum = Math.round(n*0.15f);
        int valueSum = 0;
        for(int i=removeNum; i<n-removeNum; i++){
            valueSum += values[i];
        }
        int valueAvg = Math.round((float)valueSum/(n-2*removeNum));
        // Math.rouond((float))는 int 반환하지만,
        // Math.round((double))은 long 반환

        
        System.out.println(valueAvg); 
    }

}