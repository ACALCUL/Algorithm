import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Main{
    public static void main(String[] args)  throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int i = Integer.parseInt(br.readLine());

      int k;
      for(int j=1; j<i+1; j++){
        for(k=0; k<j; k++){
          System.out.print("*");
        }
        System.out.println("");
      }

    }
}