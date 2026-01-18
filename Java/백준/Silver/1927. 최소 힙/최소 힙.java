import java.io.*;
import java.util.*;

public class Main {
    private static class MinHeap{
        // minheap의 조건 
        // 1. 이진 완전 트리(자식->부모: i/2, 부모->자식: 2*i, 2*i+1)
        // 2. 부모는 자식보다 값이 작아야 한다

        List<Integer> heap;

        MinHeap(){
            heap = new ArrayList<>();
            heap.add(0);
        }

        // 삽입 (Sift-up)
        public void offer(int val) {
            // 1. 가장 끝에 추가 후, 인덱스를 current로 지정
            heap.add(val); 
            int current = heap.size() - 1;

            // 2. 부모와 비교하며 부모보다 작으면 위로 올리기
            while (current > 1 && heap.get(current) < heap.get(current / 2)) {
                swap(current, current / 2);
                current /= 2;
            }
        }

        // 삭제 (Sift-down)
        public int poll() {
            if (heap.size() <= 1) return 0;

            int root = heap.get(1); // 루트 노드(최솟값) 리턴

            // Tree 재구성

            // 1. 마지막 노드를 루트로 이동
            heap.set(1, heap.get(heap.size() - 1));
            heap.remove(heap.size() - 1);

            // 2. 자식과 비교하며 아래로 내리기
            int current = 1;
            while (current * 2 < heap.size()) {
                int minChild = current * 2; // 왼쪽 자식을 일단 작은 쪽으로 설정
                int rightChild = current * 2 + 1;

                // 오른쪽 자식이 있고, 왼쪽보다 더 작다면 교체 대상 변경
                if (rightChild < heap.size() && heap.get(rightChild) < heap.get(minChild)) {
                minChild = rightChild;
                }

                // 부모가 자식보다 작으면 멈춤(정상 상태이므로 트리 재구성 필요 X)
                if (heap.get(current) < heap.get(minChild)) break;

                // break가 안됬으면 부모가 자식보다 크므로 부모와 자식 바꾸기
                swap(current, minChild);
                current = minChild;
            }

            return root;
        }

        private void swap(int i, int j) {
            int temp = heap.get(i);
            heap.set(i, heap.get(j));
            heap.set(j, temp);
        }

    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        MinHeap minheap = new MinHeap();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            int num = Integer.parseInt(br.readLine());
            if(num>0){
                minheap.offer(num);
            } else if(num ==0){
                sb.append(minheap.poll()).append("\n");
            } else {}
        }
        System.out.print(sb.toString());
    }
}