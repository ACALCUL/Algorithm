import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int result=0;
        for(int i=0; i<5; i++){
            int n = Integer.parseInt(st.nextToken());
            result+=n*n;
        }
        result%=10;
        System.out.println(result);
    }
}