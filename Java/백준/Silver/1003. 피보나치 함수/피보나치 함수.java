import java.io.*;

public class Main {
    private static class FibonacciOptimizer { // 타뷸레이션(바텀업+저장)+포인터(타뷸레이션 심화 기법)를 이용한 피보나치 함수
    private static long[] memo = new long[101]; 
    private static int lastCalculated = 1;      // pointer: 어디까지 기록했나를 확인

    static {
        memo[0] = 0;
        memo[1] = 1;
    }

    public static long getFibonacci(int n) {
        if (n <= lastCalculated) return memo[n]; // 포인터 이하면 바로 반환

        // 포인터보다 크면 포인터 다음 지점부터 n까지만 계산 및 저장
        for (int i = lastCalculated + 1; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        lastCalculated = n; // 포인터 업데이트
        return memo[n];
        }
    }

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

    private static int oneCount(int num){ // 바텀업(반복문)을 이용한 피보나치 수열과 동일
        int a=0, b=1, temp;
        for(int i=0; i<num; i++){
            temp=a;
            a=b;
            b+=temp;
        }
        return a;
    }
    
}