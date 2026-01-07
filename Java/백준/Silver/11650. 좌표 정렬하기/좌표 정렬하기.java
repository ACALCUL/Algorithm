import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.Arrays;

class Point{
    // 최상위 클래스는 deault, public만 가능한데 public은 파일당 하나만 가능
    // 파일 클래스가 이미 public이므로 이 클래스는 default만 가능
    // 파일 클래스는 public이든 default든 상관없음
    int x;
    int y;
    Point(int x, int y){
        this.x= x;
        this.y= y;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Point[] p = new Point[n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            p[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(p, (a,b)->{
            if(a.x != b.x){
                //return a.x - b.x;
                return Integer.compare(a.x, b.x); 
                // 오버플로우가 발생하지 않으므로 이 방식이 미세하게 좋음
            }
            else{
                return a.y - b.y;
            }
        });

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            sb.append(p[i].x).append(" ").append(p[i].y).append("\n");
        }

        System.out.print(sb.toString());

    }
}