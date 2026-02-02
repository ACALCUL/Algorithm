import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] curArray = new int[n];
        int[] lastArray = new int[n];
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<i; j++){
                curArray[j] = Integer.parseInt(st.nextToken());
                if(j==0){
                    curArray[j] += lastArray[0];
                } else if(j==i-1){
                    curArray[j] += lastArray[j-1];
                }else{
                    curArray[j] += Math.max(lastArray[j-1], lastArray[j]);
                }
            }
            int[] temp = lastArray;
            lastArray = curArray;
            curArray = temp;
        }

        //System.out.println(Arrays.toString(lastArray));
        int max = 0;
        for(int i=0; i<n; i++){
            max = Math.max(max, lastArray[i]);
        }

        System.out.println(max);
    }
    
}