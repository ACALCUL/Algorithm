import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    static class Human{ // main이 static이므로 이 객체도 static
        int age;
        String name;
        Human(int age, String name){
            this.age = age;
            this.name = name;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        Human[] h = new Human[n];
        
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            h[i] = new Human(age, name);
        }

        Arrays.sort(h, (a,b)->{
            //return a.age()-b.age(); // 값이 너무 크면 오버플로우 가능성 있음 -> 나이이므로 상관없음
            return Integer.compare(a.age, b.age);
        });

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++){
            
            sb.append(h[i].age).append(" ");
            sb.append(h[i].name).append("\n");
        }

        System.out.print(sb.toString());
    }
}