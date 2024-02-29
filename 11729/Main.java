import java.io.*;

public class Main {
    static void hanoi(int a, int b, int n, BufferedWriter bw) throws IOException {
        if (n == 1) {
            bw.write(a + " " + b + "\n");
            return;
        }

        hanoi(a, 6-a-b, n-1, bw);   // n-1개의 원판을 나머지 한 기둥으로 이동
        bw.write(a + " " + b + "\n"); // n번째 원판을 b번 기둥으로 이동
        hanoi(6-a-b, b, n-1, bw);   // n-1개의 원판을 b번 기둥으로 이동
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int cnt = (int)Math.pow(2, N)-1; // 2^n - 1
        bw.write(cnt + "\n");
        bw.flush();
        hanoi(1, 3, N, bw);
        bw.flush();
        bw.close();
    }
}
