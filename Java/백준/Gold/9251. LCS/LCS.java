import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = " "+br.readLine();
        String s2 = " "+br.readLine();
        
        System.out.println(getLCSLength(s1, s2));
    }
    private static int getLCSLength(String s1, String s2){
        int[][] LCSLength = new int[s1.length()][s2.length()];
        // LCSLength[i][j] = s1의 i번째 인덱스까지, s2의 j번째 인덱스까지 고려했을 떄의 LCSLength

        for(int i=1; i<s1.length(); i++){
            for(int j=1; j<s2.length(); j++){
                if(s1.charAt(i)==s2.charAt(j)){
                    LCSLength[i][j]=LCSLength[i-1][j-1]+1;
                }else{
                    LCSLength[i][j]=Math.max(LCSLength[i][j-1], LCSLength[i-1][j]);
                }
                // System.out.println(String.format("LCS[%d][%d] = %d", i, j, LCSLength[i][j]));
            }
        }

        return LCSLength[s1.length()-1][s2.length()-1];
    }
}