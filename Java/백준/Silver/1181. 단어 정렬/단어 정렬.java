import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList; // add, get, set, remove, size 등의 메소드
import java.util.Collections; // sort 등의 메소드

public class Main {   
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<String> sentence = new ArrayList<String>();
        for(int i=0; i<n; i++){
            sentence.add(br.readLine());
        }
        
        // sort: 정렬 메소드(Arrays와 Collections의 메소드)
        // 첫번째 인자에 객체
        // 두번째 인자에 Comparator 객체: 커스텀 방법을 알려줌, 생략시 오름차순
        // Comparator의 리턴값은 int형. 음수면 a, b 순서, 같으면 순서 유지, 양수면 b, a 순서
        Collections.sort(sentence, (a, b)->{
            if(a.length() != b.length()){
                return a.length()-b.length();
            } else{
                return a.compareTo(b);
            }
        });
        // 원래는 new Comparotor<String>(){@Override}가 필요하지만,
        // 람다로 간편하게 사용 가능: (parameters) -> expression (실행코드, 반환값)

        for(int i=0; i<sentence.size()-1; i++){
            if(sentence.get(i).equals(sentence.get(i+1))){
                sentence.remove(i);
                i--;
                // <틀린 이유> 칸이 한칸씩 땡겨졌으니 i번째 인덱스 다시 검사
            }
        }
        

        StringBuilder sb = new StringBuilder();

        for(String s: sentence){
            sb.append(s+"\n");
        }
        System.out.print(sb.toString());
    }
    
}