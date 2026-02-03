import java.io.*;
import java.util.*;

public class Main {

    private static class Node{
        char name;
        Node left, right;
        Node(char name){
            this.name = name;
        }
    }
 
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<Character, Node> map = new HashMap<>();
        for(int i=0; i<N; i++){
            char c = (char)('A'+i);
            map.put(c, new Node(c));
        }
        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            Node temp = map.get(st.nextToken().charAt(0));
            char c = st.nextToken().charAt(0);
            if(c != '.'){
                temp.left = map.get(c);
            } 
            c = st.nextToken().charAt(0);
            if(c != '.'){
                temp.right = map.get(c);
            }
        }

        preorder(map.get('A'));
        sb.append("\n");
        inorder(map.get('A'));
        sb.append("\n");
        postorder(map.get('A'));
        sb.append("\n");
        System.out.print(sb.toString());
    }

    private static void preorder(Node node){
        if(node != null){
            sb.append(node.name);
            preorder(node.left);
            preorder(node.right);
        }
    }

    private static void inorder(Node node){
        if(node != null){
            inorder(node.left);
            sb.append(node.name);
            inorder(node.right);
        }
    }

    private static void postorder(Node node){
        if(node != null){
            postorder(node.left);
            postorder(node.right);
            sb.append(node.name);
        }
    }
    
}