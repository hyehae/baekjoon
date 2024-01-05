import java.io.*;
import java.util.*;

public class Main {
//    public static void Quick(int[] arr, int left, int right) {
//        if(left > right) {
//            return;
//        }
//
//        int pivot = left;
//        int i = left+1;
//        int j = right;
//
//        while(i <= j) {
//            while(arr[i] < arr[pivot]) {
//                i++;
//            }
//
//            while(arr[j] > arr[pivot]) {
//                j--;
//            }
//
//            if(i < j) {
//                int tmp = arr[i];
//                arr[i] = arr[j];
//                arr[j] = tmp;
//            } else {
//                break;
//            }
//        }
//
//        int tmp = arr[pivot];
//        arr[pivot] = arr[j];
//        arr[j] = tmp;
//
//        Quick(arr, 0, j-1);
//        Quick(arr, j+1, right);
//    }

    public static Boolean BinarySearch(int[] arr, int len, int num) {
        int left = 0;
        int right = len-1;

        while(left <= right) {
            int mid = (left + right) / 2;
            if (num == arr[mid]) {
                return true;
            } else if (num < arr[mid]) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] card = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }

//        Quick(card, 0, N-1);
        Arrays.sort(card);

        int M = Integer.parseInt(br.readLine());
        int[] num = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        for(int n : num) {
            if(BinarySearch(card, N, n)) {
                sb.append("1 ");
            } else {
                sb.append("0 ");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
