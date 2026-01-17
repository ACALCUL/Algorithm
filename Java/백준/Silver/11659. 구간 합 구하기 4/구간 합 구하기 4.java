import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        int n= Integer.parseInt(st.nextToken());
        int m= Integer.parseInt(st.nextToken());

        st= new StringTokenizer(br.readLine());
        int[] arr = new int[n+1];
        for(int i=1; i<=n; i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        //System.out.println(Arrays.toString(arr));

        for(int i=1; i<=n; i++){
            arr[i]+=arr[i-1];
        }
        //System.out.println(Arrays.toString(arr));

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m; i++){
            st= new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end= Integer.parseInt(st.nextToken());
            sb.append(arr[end]-arr[start-1]).append("\n");
        }

        System.out.print(sb.toString());

    }    
}