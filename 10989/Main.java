import java.io.*;

public class Main {
    public static void Counting(int[] sorted, int[] arr, int N) {
        int[] counting = new int[10001];

        for(int i=0; i<N; i++) {
            counting[arr[i]]++;
        }

        for(int i=1; i<counting.length; i++) {
            counting[i] = counting[i-1] + counting[i];
        }

        for(int i=N-1; i>=0; i--) {
            int value = arr[i];
            counting[value]--;
            sorted[counting[value]] = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] sorted = new int[N];

        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Counting(sorted, arr, N);

        for(int a : sorted) {
            bw.write(a + "\n");
        }
        bw.flush();
        bw.close();
    }
}