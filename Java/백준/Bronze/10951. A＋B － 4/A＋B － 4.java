import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        
        String s;
        while( (s=br.readLine()) != null){ 
        // Ctrl+D로 EOF를 보내면 br.readLine()이 null을 반환 -> 등호로 비교
        // 주솟값이 null: 아무것도 참조하지 않아 주솟값이 없음을 의미
            st= new StringTokenizer(s);
            sb.append(Integer.parseInt(st.nextToken())+Integer.parseInt(st.nextToken())).append("\n");
        }
        System.out.print(sb.toString());
    }
} 