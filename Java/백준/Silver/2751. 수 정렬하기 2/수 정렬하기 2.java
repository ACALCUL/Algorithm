import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];
        for(int i=0; i<n; i++){
            numbers[i]=Integer.parseInt(br.readLine());
        }
        Arrays.sort(numbers);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            sb.append(numbers[i]+"\n");
        }
        // System.out.println(Arrays.toString(numbers)); [1,2,3,4,5]와 같은 형태
        System.out.print(sb.toString());


    }
}