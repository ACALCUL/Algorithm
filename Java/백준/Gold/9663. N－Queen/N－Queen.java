import java.io.*;

public class Main {
    static int N;
    static int[] cols;
    static int count=0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cols = new int[N+1];
        nqueens(0);
        System.out.println(count);
    }

    private static void nqueens(int row){
        if(promising(row)){
            if(row==N){
                // for(int i=1; i<=N; i++){
                //     System.out.print(String.format("(%d, %d) ", i, cols[i]));
                // }
                // System.out.println();
                count++;
            } else{
                for(int col = 1; col<=N; col++){
                    cols[row+1]=col;
                    nqueens(row+1); // dfs와 비슷한 느낌
                }
            }
        }
    }

    private static boolean promising(int row){
        int lastrow=1;

        while(lastrow<row){
            if(cols[row]==cols[lastrow] ||
                Math.abs(row-lastrow) == Math.abs(cols[row] - cols[lastrow])){
                return false;
            }
            lastrow++;
        }
        return true;
    }
}
