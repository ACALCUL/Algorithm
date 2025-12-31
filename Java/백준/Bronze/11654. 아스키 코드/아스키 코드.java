// main: 문자 한개를 입력하면 그에 맞는 아스키 코드 번호로 출력
// num_to_ASCII: 각 아스키 코드 번호에 맞는 문자 출력
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void num_to_ASCII(){
        StringBuilder sb = new StringBuilder();
        for(int i =0; i<128; i++){
            sb.append(String.format("%d : %c\n", i, (char)i));
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        int c = br.readLine().charAt(0);
        System.out.println(c);
        //Bronze8.num_to_ASCII();
    }
}