import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str;
        while(true){
            str = br.readLine();
            if(str.equals("0")){
                break;
            }
            if(isPal(str)){
                sb.append("yes\n");
            }
            else{
                sb.append("no\n");
            }
        } 
        System.out.print(sb.toString());
    }

    // static 메소드가 부르는 메소드도 static이여야함
    // 왜냐하면 static은 객체가 생성되기 전에 생성됨
    static public boolean isPal(String str){
        boolean result=true;
        for(int i=0; i<str.length()/2; i++){
            if(str.charAt(i) != str.charAt(str.length()-1-i) ){
                result=false;
            }
        }
        return result;
    }
}