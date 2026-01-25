import java.io.*;
import java.util.*;

public class Main {
    // 1~N의 숫자 중 서로 다른 숫자 M개를 고른 수열을 오름차순으로 출력
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 가능한 숫자의 범위: 1~N
        int M = Integer.parseInt(st.nextToken()); // 선택할 숫자의 개수; M

        Queue<int[]> queue = new ArrayDeque<>();
        int[] curSequence;
        int[] nextSequence;
        for(int i=1; i<=N; i++){
            curSequence = new int[M+1];
            curSequence[0] = 1;
            curSequence[1] = i;
            queue.offer(curSequence);
        }
        
        // // 출력용
        // while(!stack.isEmpty()){
        //     System.out.println(Arrays.toString(stack.pop()));
        // }
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()){
            curSequence = queue.poll();
    
            if(curSequence[0] == M){ // Sequence is completed
                for(int i=1; i<=M; i++){
                    sb.append(curSequence[i]).append(" ");
                }
                sb.setLength(sb.length()-1);
                sb.append("\n");
                continue;
            }
            // Sequence isn't completed
            for(int i=1; i<=N; i++){ // i: num to put in Sequence
                boolean isValid = true;
                for(int j=1; j<=curSequence[0]; j++){
                    if(i==curSequence[j]){ isValid = false; break; }
                }
                if(isValid){ // if i is valid
                    nextSequence = Arrays.copyOf(curSequence, curSequence.length);
                    nextSequence[0]++;
                    nextSequence[nextSequence[0]]=i;
                    queue.offer(nextSequence);
                }
            }
        }

        System.out.print(sb.toString());
    }    
}