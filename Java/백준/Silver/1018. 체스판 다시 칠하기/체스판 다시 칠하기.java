import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
    
        char[][] board = new char[n][m];
        for(int i=0; i<n; i++){
            board[i]=br.readLine().toCharArray();
        }
        
        int minColorCount=64;
        int colorCount;

        for(int i=0; i<=n-8; i++){
            for(int j=0; j<=m-8; j++){
                colorCount=countColor(board, i, j);
                minColorCount=(minColorCount<colorCount)?minColorCount: colorCount;
            }
        }

        System.out.println(minColorCount);
    }

    private static int countColor(char[][] board, int start_x, int start_y){
        int colorCount=0;
        int adjustmentAmount=0;
        char startColor='W';
        for(int i=start_x; i<start_x+8; i++){
            for(int j=start_y; j<start_y+8; j++){ // 8*8만 봄
                if((i+j+adjustmentAmount)%2==0){ // start_color와 다르면 count++
                    if(startColor!=board[i][j]){
                        colorCount++;
                    }
                } else{ // start_color와 같으면 count++
                    if(startColor == board[i][j]){
                        colorCount++;
                    }
                }
            }
        }
        // 'B'일 경우의 colorCount는 64-colorCount
        return (colorCount<64-colorCount)?colorCount:64-colorCount;
    }

}