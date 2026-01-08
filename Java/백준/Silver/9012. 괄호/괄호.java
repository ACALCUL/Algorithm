import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Deque;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());

        Deque<Character> stack = new ArrayDeque<Character>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            sb.append(solve(br.readLine(), stack)).append("\n");
        }
        System.out.print(sb.toString());
    }

    // 이 폴더 안에 solve 메소드가 많을 것이므로 접근제어자를 private으로
    private static String solve(String s, Deque<Character> stack){
        stack.clear();

        for(int j=0; j<s.length(); j++){
            if(s.charAt(j)=='('){
                stack.offerFirst('(');
            } else{ // s.charAt(j)==')'일 경우
                if(stack.pollFirst()==null){
                    return "NO";
                }
            }
        }

        return stack.isEmpty()?"YES":"NO";
    }

}