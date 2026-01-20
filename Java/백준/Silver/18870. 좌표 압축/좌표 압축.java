import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] origin = new int[n];
        for(int i=0; i<n; i++){
            origin[i] = Integer.parseInt(st.nextToken());
        }
        //int[] sorted = Arrays.copyOf(origin, origin.length);
        int[] sorted = Arrays.stream(origin).distinct().sorted().toArray();
        
        // stream 객체에 쓰이는 메소드 이름은 모두 형용사
        // distinct: 눈에 띄는, 별개의 -> 중복제거
        // 사용자 정의 sorted에 필요한 Compartor은 제네릭이로 Integer 객체 필요
        // -> sorted() 앞, 뒤에 boxed()과 maptoInt(Integer::intValue) 필요

        StringBuilder sb = new StringBuilder();
        // sb.append(Arrays.toString(origin)).append("\n");
        // sb.append(Arrays.toString(sorted));
        for(int num: origin){
            sb.append(Arrays.binarySearch(sorted, num)).append(" ");
        }
        sb.setLength(sb.length()-1);


        System.out.println(sb.toString());

    }
}