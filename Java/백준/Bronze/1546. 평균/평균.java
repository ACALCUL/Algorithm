import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        double score;
        double sum_score=0;
        double max_score=0;
        for(int i=0; i<n; i++){
            score = Double.parseDouble(st.nextToken());
            sum_score += score;
            if(score > max_score){
                max_score = score;
            }
        }
        System.out.println(sum_score/n/max_score*100);

    }
}