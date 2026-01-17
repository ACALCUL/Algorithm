import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        int[] DP = new int[n+1];
        DP[1]=1;
        if(n>1){
            DP[2]=2;
        }
        for(int i=3; i<=n; i++){
            DP[i]=(DP[i-1]+DP[i-2])%10007;
        }
        System.out.println(DP[n]);
    }
}