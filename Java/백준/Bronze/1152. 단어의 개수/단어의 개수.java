// 입력값에 대해 단어가 몇 개인지 알려주는 프로그램
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        String s = br.readLine();
        int count = 0;

        if(s.equals(" ") || s.equals("")){
            System.out.println(count);
            return;
        }

        for(int i = 1; i < s.length()-1; i++){
            if(s.charAt(i) == ' ')
                count++;
        }
        //char, int와 같은 기본형의 내용 비교는 ==이지만, 객체의 내용 비교는 .equal()을 사용
        System.out.println(++count);
    }
}