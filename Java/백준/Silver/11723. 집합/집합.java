import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    private static class Set{
        boolean[] arr = new boolean[21];

        void add(int num){
            arr[num]=true;
        }
        void remove(int num){
            arr[num]=false;
        }
        int check(int num){
            return (arr[num]==false)?0:1;
        }
        void toggle(int num){
            arr[num] = !arr[num];
        }
        void all(){
            for(int i=1; i<=20; i++){
                arr[i]=true;
            }
        }
        void empty(){
            for(int i=1; i<=20; i++){
                arr[i]=false;
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Set set = new Set();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            switch(st.nextToken()){
                case "add":
                    set.add(Integer.parseInt(st.nextToken()));
                    break;
                case "remove":
                    set.remove(Integer.parseInt(st.nextToken()));
                    break;
                case "check":
                    sb.append(set.check(Integer.parseInt(st.nextToken()))).append("\n");
                    break;
                case "toggle":
                    set.toggle(Integer.parseInt(st.nextToken()));
                    break;
                case "all":
                    set.all();
                    break;
                case "empty":
                    set.empty();
                    break;
            }
        }
        System.out.print(sb.toString());
    }
}