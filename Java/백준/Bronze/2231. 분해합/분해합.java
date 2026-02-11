import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(solve(n));
    }

    private static int solve(int n){
        int numDigit=0;
        for(int i=1; n/i!=0; i*=10){
            numDigit++;
        }
        // System.out.println(numDigit);

        for(int curNum=n-9*numDigit; curNum<=n; curNum++){
            // System.out.println("curNum: "+ curNum);
            int count = curNum;
            for(int i = 1; curNum/i!=0; i*=10){
                int digitNum = curNum/i%10;
                // System.out.println(digitNum);
                count+=digitNum;
            }
            // System.out.println("count: "+count);
            if(count == n){
                return curNum;
            }
        }
        return 0;
    }
}