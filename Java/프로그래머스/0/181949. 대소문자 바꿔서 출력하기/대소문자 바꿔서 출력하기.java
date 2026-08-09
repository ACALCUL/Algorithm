import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int diff = 'a'-'A';
        StringBuilder sb = new StringBuilder();
        for(int c: str.toCharArray()){
            if( c < (int)'a'){
                // c is lower character
                sb.append((char)(c+diff));
            }else{
                sb.append((char)(c-diff));
            }
        }
        System.out.println(sb.toString());

    }
}