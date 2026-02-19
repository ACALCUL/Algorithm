import java.io.*;

public class Main {
    private static long MOD = 1_000_000_007L;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long[][] start = new long[2][2];
        start[0][0] = 1;
        start[0][1] = 1;
        start[1][0] = 1;
        start[1][1] = 0;

        long[][] result = power(start, n);
        // result의 (0,1) 또는 (1,0)이 n번째 피보나치 
        System.out.println(result[0][1]);
    }
    // 피보나치 수열을 구할 때 모든 matrix(행렬)은 2x2

    // M1과 M2의 곱을 리턴
    private static long[][] multiply(long[][] M1, long[][] M2){
        long[][] result = new long[2][2];
        for(int i=0; i<2; i++){
            for(int j=0; j<2; j++){
                for(int k=0; k<2; k++){
                    result[i][j] = (result[i][j] + M1[i][k] * M2[k][j]) % MOD;
                }
            }
        }
        return result;
    }

    // M의 n거듭제곱을 리턴
    private static long[][] power(long[][] M, long n){
        if(n == 1) return M;
        if(n%2 == 1) return multiply(M, power(M, n-1));
        // n%2 == 0일 경우
        long[][] half = power(M, n/2);
        return multiply(half, half);
    }

}

