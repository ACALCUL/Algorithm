import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int score = Integer.parseInt(br.readLine());
        char rate;
        if(score>=90){
            rate = 'A';
        } else if(score>=80){
            rate = 'B';
        } else if(score>=70){
            rate = 'C';
        } else if (score>=60){
            rate = 'D';
        } else{
            rate = 'F';
        }
        System.out.println(rate);
    }   
    
}
