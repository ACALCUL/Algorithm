import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Queue;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        Queue<Integer> list = new ArrayDeque<Integer>();
        // ArrayDeque를 Queue로 업캐스팅

        // Queue: offer(tail에 값 추가), poll(head를 꺼내고 반환), peek(head 조회)
        // Stack: push(head에 값 추가), pop(head를 꺼내고 반환), peek
        // Double End Queue: 
        // head 관련 메소드: offerFirst, pollFirst, peekFirst
        // tail 관련 메소드: offerLast, pollLast, peekLast
        for(int i=0; i<n; i++){
            list.offer(i+1);
            // new Integer() 대신 사용
            // 원시타입과 Wrapping된 참조타입간에는 자동박싱과 자동언박싱이 됨
        }

        for(int i=0; i<n-1; i++){
            list.poll();
            list.offer(list.poll());
        }

        System.out.println(list.peek());
    }
}
