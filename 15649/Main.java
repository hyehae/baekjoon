import java.io.*;
import java.util.Arrays;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;
    static int[] series;
    static boolean[] isUsed;

    static void buildSeries(int cur) throws IOException {
        if (cur == M) {
            for (int i = 0; i < M; i++) {
                bw.write(series[i] + " ");
            }
            bw.write("\n");
            bw.flush();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!isUsed[i]) {
                series[cur] = i;
                isUsed[i] = true;
                buildSeries(cur+1);
                isUsed[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        series = new int[9];
        isUsed = new boolean[9];
        Arrays.fill(isUsed, false);

        buildSeries(0);

        bw.close();
    }
}
