// to get LCM and GCD: O(logn) version
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

        int GCD = getGCD(num1, num2); // Greatest Common Divisor
        int LCM = num1*num2/GCD; // Least Common Multiple
        // 최소공배수는 간단히 식으로 나옴
        
        System.out.println(GCD);
        System.out.println(LCM);
    }

    // 최대공약수(GCD)를 쉽게 구하기 위한 호제법
    public static int getGCD(int num1, int num2){
        while(num2 != 0){
            int r = num1 % num2;
            num1 = num2;
            num2 = r;
        }
        return num1;
    }
}