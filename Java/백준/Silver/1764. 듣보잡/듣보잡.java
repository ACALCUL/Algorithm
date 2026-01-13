import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n =Integer.parseInt(st.nextToken());
        int m= Integer.parseInt(st.nextToken());
        HashSet<String> set = new HashSet<String>();
        // HashSet: add, remove, contains, size, clear 등의 ArrayList의 메소드와 유사
        ArrayList<String> arr = new ArrayList<String>();
        for(int i=0; i<n; i++){
            set.add(br.readLine());
        }
        String buf;
        for(int i=0; i<m; i++){
            buf = br.readLine();
            if(set.contains(buf)){
                arr.add(buf);
            }
        }
        arr.sort(Comparator.naturalOrder());
        //sort의 변수로 Comparator 객체를 넘겨야 함
        StringBuilder sb = new StringBuilder();
        int arrSize= arr.size();
        sb.append(arrSize).append("\n");
        for(int i=0; i<arrSize; i++){
            sb.append(arr.get(i)).append("\n");
        }
        System.out.print(sb.toString());

    }
}
