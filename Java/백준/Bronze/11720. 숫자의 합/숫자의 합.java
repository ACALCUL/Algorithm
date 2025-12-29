// 첫째 줄에 숫자의 개수가 주어지고 
// 둘째 줄에 공백없이 0-9의 숫자 n개가 주어졌을 때 주어진 숫자의 합을 출력
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String numbers= br.readLine();
        int sum = 0;

        for(int i=0; i<n; i++){
            sum += numbers.charAt(i)-'0';
            //char을 int로 변환시 아스키코드 값으로 변하므로 
            //char 1을 int 1로 바꾸고 싶다면 형변환 후 -'0' 해주기
        }
        System.out.println(sum);
    }
}