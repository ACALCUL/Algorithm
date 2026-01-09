import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n= Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A= new int[n];
        for(int i=0; i<n; i++){
            A[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        int m=Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb= new StringBuilder();

        for(int i=0; i<m; i++){
            int num = Integer.parseInt(st.nextToken());
            //sb.append(countNum(A, num)).append(" ");
            sb.append(upperBound(A, num)-lowerBound(A,num)).append(" ");
        }

        System.out.println(sb.toString());

    }

    private static int countNum(int[] array, int num){ // 중복이 많은 경우 시간복잡도가 n이므로 기각
        int count=0;
        int index = Arrays.binarySearch(array, num);
        if(index<0){
            return 0;
        }
        int buf=index;
        while(buf>=0&&array[buf]==num){
                buf--;
                count++;
            }
        buf=index+1;
        while(buf<array.length&&array[buf]==num){
            buf++;
            count++;
        }
        return count;
    }

    private static int lowerBound(int[] array, int target){
        int low=0;
        int high=array.length;
        int mid;
        while(low<high){
            mid = low+(high-low)/2;
            if(target<=array[mid]){
                high=mid;
            } else{
                low=mid+1;
            }
        }
        return low;
    }

    private static int upperBound(int[] array, int target){
        int low=0;
        int high=array.length;
        int mid;
        while(low<high){
            mid = low+(high-low)/2;
            if(target<array[mid]){
                high=mid;
            } else{
                low=mid+1;
            }
        }
        return low;
    }


}
