import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i= 0; i<n; i++){
            int num = Integer.parseInt(br.readLine());
            sb.append(zeroCount(num)).append(" ");
            sb.append(oneCount(num)).append("\n");
        }
        System.out.print(sb.toString());
    }

    private static int zeroCount(int num){
        int zeroCount;
        if(num<1){
            zeroCount=1;
        }else{
            zeroCount=oneCount(num-1);
        }
        return zeroCount;
    }

    private static int oneCount(int num){ // 피보나치 수열과 동일
        int a=0, b=1, temp;
        for(int i=0; i<num; i++){
            temp=a;
            a=b;
            b+=temp;
        }
        return a;
    }
    
}