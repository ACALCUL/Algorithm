import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());

        int[] addCase = new int[11];
        addCase[1]=1;
        addCase[2]=2;
        addCase[3]=4;
        for(int i=4; i<11; i++){
            addCase[i] = addCase[i-1]+addCase[i-2]+addCase[i-3];
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            sb.append(addCase[Integer.parseInt(br.readLine())]).append("\n");
        }
        System.out.print(sb.toString());
    }
}