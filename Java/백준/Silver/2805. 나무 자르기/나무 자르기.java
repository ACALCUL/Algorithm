import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] trees = new int[n];
        st= new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            trees[i] = Integer.parseInt(st.nextToken());
        }
        //System.out.println(Arrays.toString(trees));
        System.out.println(getHeight(n, m, trees));

    }

    private static long getHeight(int n, int m, int[] trees){
        long low=0;
        long high=0;
        for(int i=0; i<n; i++){
            high = Math.max(high, trees[i]);
        }

        // false가 나오는 최솟값 찾기
        // lowerBound 원리를 사용 -> 시간복잡도 log(sum_trees)로 줄임
        while(low<high){
            long mid=low+(high-low)/2;
            if(isVaild(mid, n, m, trees)==false){
                high=mid;
            } else{
                low=mid+1;
            }
        }
        // low는 false가 나오는 최솟값 -> -1을 하면 true가 나오는 최댓값
        return low-1;
    }

    // 시간복잡도 n
    private static boolean isVaild(long cutHeight, int n, int m, int[] trees){
        long getHeight=0;
        for(int i=0; i<n; i++){
            if((trees[i]-cutHeight)>0){
                getHeight+=trees[i]-cutHeight;
            }
        }
        return getHeight>=m;
    }

    // 참고용 lowerBound
    private static int lowerBound(int low, int high, int[] arr, int target){ 
        // upperBound는 if문에 등호만 제거
        // binarySearch는 조건문에 등호조건 있고, 등호조건 만족 시 mid 리턴, while문 바깥은 -1 리턴
        while(low<high){
            int mid = low+(high-low)/2;
            if(arr[mid]>=target) { // 조건 만족
                high=mid; // 조건 만족했으므로 자기(mid) 포함하여 아래쪽을 탐색
            } else {
                low=mid+1;
            }
        }
        return low;
    }

}