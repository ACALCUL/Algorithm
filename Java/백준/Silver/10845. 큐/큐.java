import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    private static class Queue{
        int head = -1;
        int tail= -1;
        int[] array = new int[10000];

        void push(int num){
            if(tail+1<10000){
            array[++tail]=num;
            }
        }
        int pop(){
            if(empty()==1){
                return -1;
            }
            return array[++head];
        }
        int size(){
            return tail-head;
        }
        int empty(){
            return size()==0?1:0;
        }
        int front(){
            if(empty()==1){
                return -1;
            }
            return array[head+1];
        }
        int back(){
            if(empty()==1){
                return -1;
            }
            return array[tail];
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s;
        Queue queue= new Queue();
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++){
            s= br.readLine();
            //sb.append("입력한 값: ").append(s).append("\n").append("출력한 값: ");
            switch(s){
                case "pop":
                    sb.append(queue.pop()).append("\n");
                    break;
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty":
                    sb.append(queue.empty()).append("\n");
                    break;
                case "front":
                    sb.append(queue.front()).append("\n");
                    break;
                case "back":
                    sb.append(queue.back()).append("\n");
                    break;
                default:
                    if(s.substring(0,5).equals("push ")){
                        st = new StringTokenizer(s);
                        st.nextToken();
                        queue.push(Integer.parseInt(st.nextToken()));
                    }
                    break;
            }
        }

        System.out.print(sb.toString());
    }
}