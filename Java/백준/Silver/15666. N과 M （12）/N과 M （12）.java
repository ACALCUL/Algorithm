import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        int[] arr = new int[M];
        getSeq(N, nums, M, arr, 0, 0);
        System.out.print(sb.toString());
    }

    private static void getSeq(int N, int[] nums, int M, int[] arr, int depth, int startIndex){
        if(depth == M){
            for(int val: arr){
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=startIndex; i<N; i++){
            if(i+1<N && nums[i]==nums[i+1]){
                continue;
            }
            arr[depth]=nums[i];
            getSeq(N, nums, M, arr, depth+1, i);
        }
    }
}