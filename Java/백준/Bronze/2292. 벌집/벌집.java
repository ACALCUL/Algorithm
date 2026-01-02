import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] ars) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int level=1;
        int level_num=1;
        for(; level_num < n ; level++){
            level_num+=6*level;
            //System.out.println(level_num);
        }
        System.out.println(level);

    }
}
