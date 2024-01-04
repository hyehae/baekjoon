import java.io.*;

public class Main {
    public static void Swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void Heapify(int[] arr, int parent, int len) {
        int curParent = parent;
        int leftChild = parent*2 + 1;
        int rightChild = parent*2 + 2;

        if(leftChild < len && arr[curParent] < arr[leftChild]) {
            curParent = leftChild;
        }

        if(rightChild < len && arr[curParent] < arr[rightChild]) {
            curParent = rightChild;
        }

        if(curParent != parent) {
            Swap(arr, parent, curParent);
            Heapify(arr, curParent, len);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 초기 힙 구성
        for(int i=(N/2)-1; i>=0; i--) {
            Heapify(arr, i, N);
        }

        // 힙 정렬
        for(int i=N-1; i>0; i--) {
            Swap(arr, 0, i);
            Heapify(arr, 0, i);
        }

        // 출력
        for(int a : arr) {
            bw.write(a+"\n");
        }
        bw.flush();
        bw.close();
    }
}
