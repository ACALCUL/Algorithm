import java.io.*;

// 타뷸레이션을 사용: i=2부터 n까지 탐색하는 비효율은 있지만, 반복문의 효율성으로 재귀문보다 빠름
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] countArr= new int[n+1];

        for(int i=2; i<=n; i++){
            int cnt;
            cnt=countArr[i-1]+1;
            if(i%2==0){
                cnt=Math.min(cnt, countArr[i/2]+1);
            }
            if(i%3==0){
                cnt=Math.min(cnt, countArr[i/3]+1);
            }
            countArr[i]=cnt;
        }
        // for(int i=1; i<=n; i++){
        //     System.out.println(String.format("countArr[%d] = %d", i, countArr[i]));
        // }
        System.out.println(countArr[n]);
    }
}