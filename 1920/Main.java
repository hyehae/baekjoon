import java.util.*;

public class Main {
    public static boolean binarysearch(int list[], int len, int num) {
        int left = 0;
        int right = len-1;
        while(left <= right) {
            int mid = (left+right)/2;
            if(list[mid] == num) {
                return true;
            } else if (list[mid] > num) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return false;
    }

    public static void main (String args[]) throws Exception {

        int M, N;
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        int[] A = new int[N];
        for(int i=0; i<N; i++) {
            A[i] = sc.nextInt();
        }
        Arrays.sort(A);

        M = sc.nextInt();
        int[] B = new int[M];
        for(int i=0; i<M; i++) {
            B[i] = sc.nextInt();
        }

        for(int i=0; i<M; i++) {
            if(binarysearch(A, N, B[i])) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        }
    }
}
