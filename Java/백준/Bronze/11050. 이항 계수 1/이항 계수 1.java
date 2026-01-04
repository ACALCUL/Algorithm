import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int result = 1;
        for(int i=1; i<=k; i++){
            result *= n;
            n -= 1;
        }
        for(int i=2; i<=k; i++){
            result /= i;
        }
        System.out.println(result);
    }
    
}