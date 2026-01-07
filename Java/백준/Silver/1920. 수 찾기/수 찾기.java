import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            A[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        //System.out.println(Arrays.toString(A));

        int m = Integer.parseInt(br.readLine());
        int[] B = new int[m];
        st= new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            B[i]=Integer.parseInt(st.nextToken());
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m; i++){
            //sb.append(B[i]).append(": ");
            // binarySearch() 메소드: 있으면 인덱스(0, 양수) 반환, 없으면 있어야 할 위치의 보수(음수) 반환
            if(Arrays.binarySearch(A, B[i]) >= 0){
                sb.append(1).append("\n");
            } else{
                sb.append(0).append("\n");
            }
        }
        // 복잡도 MlogN
        // 각각 10^6이므로 시간 복잡도는 10^5*log2(10^5) 대략 10^6~10^7 -> 초당 10^8번보다 작음
        // log2(10^3)=10, log2(10^6)=20이므로 

        System.out.print(sb.toString());
    }
}