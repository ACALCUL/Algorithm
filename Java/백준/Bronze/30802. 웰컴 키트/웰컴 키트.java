import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] size = new int[6];
        for(int i=0; i<6; i++){
            size[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        // 문제 조건에서 T, P의 범위가 2*10^9 이상이면 long 자료형 쓰기

        int T_NUM=0;
        int P_NUM=n/P;
        int P_MOD=n%P;

        for(int i=0; i<6; i++){
            /*
            for(int j=0; j<size[i]; j+=T){
                T_NUM++;
            }
            */
            T_NUM+=(T+size[i]-1)/T;
        }
        
        System.out.println(String.format("%d\n%d %d", T_NUM, P_NUM, P_MOD));

    }
}