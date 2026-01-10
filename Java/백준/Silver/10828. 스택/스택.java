import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    private static class Stack{
        int top=-1;
        int[] array = new int[10001];

        void push(int num){
            if(top>=10000){
                return;
            }
            array[++top]=num;
        }
        int pop(){
            if(empty()==1){
                return -1;
            }
            return array[top--];
        }
        int size(){
            return top+1;
        }
        int empty(){
            return (top==-1)?1:0;
        }
        int top(){
            if(empty()==1){
                return -1;
            }
            return array[top];
        }

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s;
        // 객체는 매개변수로 쓰일 시에 주솟값 복사하므로 객체의 변수 변경 가능
        Stack stack = new Stack(); 
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++){
            s=br.readLine();
            switch(s){ // 분기 상태가 한정적이면 switch가 성능이 훨씬 좋음
                case "pop":
                    sb.append(stack.pop()).append("\n");
                    break;
                case "size":
                    sb.append(stack.size()).append("\n");
                    break;
                case "empty":
                    sb.append(stack.empty()).append("\n");
                    break;
                case "top":
                    sb.append(stack.top()).append("\n");
                    break;
                default:
                    if(s.startsWith("push ")){
                        // substring(a,b): a이상, b미만 인덱스를 리턴
                        stack.push(Integer.parseInt(s.substring(5)));
                    }
                    break;
            }

        }

        System.out.print(sb.toString());

    }

}
