import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        
        int MAX_NUM= 1000;
        boolean[] isPrime = new boolean[MAX_NUM+1];
        
        for(int i=0; i<=MAX_NUM; i++){
            isPrime[i]=true;
        }
        isPrime[0] = false;
        isPrime[1] = false;


        for(int i=2; i*i<=MAX_NUM; i++){
            if(isPrime[i]){
                for(int j=i*i; j<=MAX_NUM; j+=i){ 
                    // j=i*i인 이유: i*i보다 작은데 i의 배수는 i*n(n<i)의 형태로 이미 걸러짐
                    isPrime[j] = false;
                }
            }
        }

        /* 
        // MAX_NUM 미만의 소수 출력
        for(int i=2; i<=MAX_NUM; i++){
            if(isPrime[i]){
                System.out.println(i);
            }
        }
        */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        
        int count=0;
        for(int i=0; i<n; i++){
            int number = Integer.parseInt(st.nextToken());
            if(isPrime[number]){
                count++;
            }
        }
        System.out.println(count);
    }
}