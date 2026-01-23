import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] meetingTime = new int[n][2];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            meetingTime[i][0]=Integer.parseInt(st.nextToken());
            meetingTime[i][1]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(meetingTime, (a, b) -> {
            if(a[1]==b[1]) return Integer.compare(a[0], b[0]); // 스택오버플로우 방지를 위한 메소드
            return Integer.compare(a[1], b[1]);
        });

        // // 정렬 여부 확인용
        // for(int i=0; i<n; i++){
        //     System.out.println(meetingTime[i][0] + " "+ meetingTime[i][1]);
        // }

        int meetingCount = 0;
        int lastEndTime = -1;
        for(int i=0; i<n; i++){
            int startTime = meetingTime[i][0];
            int endTime = meetingTime[i][1];
            if(startTime >= lastEndTime){
                meetingCount++;
                //System.out.println("( "+startTime+", "+ endTime +" )");
                lastEndTime = endTime;
            }
        }

        System.out.println(meetingCount);
    }
}