import java.io.*;

public class Main {

    static int vis(int N, int r, int c) {
        if (N == 0) {
            return 0;
        }

        int half = (int)Math.pow(2, N-1); // 2차원 배열을 4등분

        if (r < half && c < half) {
            /* (r, c)가 1사분면에 위치할 때 => N-1의 (r, c)와 동일 */
            return vis(N-1, r, c);
        }

        if (r < half && c >= half) {
            /* (r, c)가 2사분면에 위치할 때 => 1사분면 총 칸 수 + (N-1, r, c-half) 결과 */
            return half * half + vis(N-1, r, c-half);
        }

        if (r >= half && c < half) {
            /* (r, c)가 3사분면에 위치할 때 => 1,2사분면 총 칸 수 + (N-1, r-half, c) 결과 */
            return 2 * half * half + vis(N-1, r-half, c);
        }

        if (r >= half && c >= half) {
            /* (r, c)가 4사분면에 위치할 때 => 1,2,3사분면 총 칸 수 + (N-1, r-half, c-half) 결과 */
            return 3 * half * half + vis(N-1, r-half, c-half);
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int r = Integer.parseInt(input[1]);
        int c = Integer.parseInt(input[2]);

        bw.write(vis(N, r, c)+"");
        bw.flush();
        bw.close();
    }
}
