import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Main{
    public static void main(String[] args)  throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String line = br.readLine();

      int year = Integer.parseInt(line);
      if( (year%4 == 0) && (year%100 != 0) || (year%400 == 0)){
        System.out.println("1");
      } else{
        System.out.println("0");
      }

    }
}