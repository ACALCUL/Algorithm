import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] array= new int[n];

        for(int i=0; i<n; i++){
            array[i]=i+1;
        }

        int[] result = new int[n];
        int pointer= -1;
        for(int i=0; i<n; i++){
            for(int j=0; j<k; j++){ // k번
                //System.out.println(String.format("%d번째 실행", j+1));
                pointer = next_pointer(array, n, pointer);
                //System.out.println(String.format("array: %s, pointer: %d\n", Arrays.toString(array), pointer));
            }
            result[i]=pointer+1;
            array[pointer]=0;
            //System.out.println(String.format("%d 삭제!", pointer+1));
            //System.out.println(String.format("array: %s, pointer: %d\n", Arrays.toString(array), pointer));
        }

        
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for (int i=0; i<n; i++){
            sb.append(result[i]);
            if(i!=n-1){
                sb.append(", ");
            }
        }
        sb.append(">");
        System.out.println(sb.toString());

    }

    private static int next_pointer(int[] array, int n, int pointer){
        int nextpointer=(pointer+1)%n;
        while(array[nextpointer]==0){
            //System.out.println(String.format("if문 들어감. pointer: %d, array[pointer]: %d", nextpointer, array[nextpointer]));
            nextpointer=(nextpointer+1)%n;
        }
        return nextpointer;
    }
}