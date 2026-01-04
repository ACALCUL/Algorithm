import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());
        int min_num = num1<num2?num1:num2;
        int max_num = num1>num2?num1:num2;
        int LCM = 1; // Least Common Multiple
        int GCD = num1 * num2; // Greatest Common Divisor
        for(int i=LCM; i<=min_num; i++){
            if(num1%i == 0 && num2%i == 0){
                LCM = i;
            }
        }
        for(int i=GCD; i>=max_num; i--){
            if(i%num1 == 0 && i%num2 == 0){
                GCD = i;
            }
        }
        System.out.println(LCM);
        System.out.println(GCD);
    }
}