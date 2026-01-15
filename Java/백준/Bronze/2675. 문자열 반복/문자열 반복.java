import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int cnt=Integer.parseInt(st.nextToken());
            String s=st.nextToken();
            for(int j=0; j<s.length(); j++){
                for(int k=0; k<cnt; k++){
                    sb.append(s.charAt(j));
                }
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}