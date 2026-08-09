import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int diff = 'a'-'A';
        for(int i=0; i<str.length(); i++){
            int code = str.charAt(i);
            if( code < (int)('a') ){ // if c is upper character
                System.out.print((char)(code+diff));
            } else{
                System.out.print((char)(code-diff));
            }
        }
    }
}