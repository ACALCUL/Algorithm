import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        

        int[] values = new int[n];
        for(int i=0; i<n; i++){
            values[i]=Integer.parseInt(br.readLine());
        }
        Arrays.sort(values);
        // System.out.println(Arrays.toString(values));

       System.out.println(getLevel(n, values)); 

    }

    private static int rounding(float num){
        return num%1 < 0.5 ? (int)num : (int)num+1;
    }

    private static int getLevel(int n, int[] values){
        if(n < 1) return 0;
        int removeNum = rounding(n*0.15f);
        int valueSum = 0;
        for(int i=removeNum; i<n-removeNum; i++){
            valueSum += values[i];
            //System.out.println("add "+values[i]);
        }
        //System.out.println(valueSum);
        //System.out.println(n-2*removeNum);
        return rounding((float)valueSum/(n-2*removeNum));
    }
}