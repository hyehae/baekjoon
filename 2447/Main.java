import java.io.*;
import java.util.Arrays;

public class Main {

    static char[][] matrix;

    static void star(int N, int x, int y) {
        /*
        * N*N 크기의 정사각형을 (N/3)*(N/3) 크기의 정사각형 9개로 나누어 각 사각형은 N=N/3으로 star 함수를 호출한다.
        * 즉, 각 함수는 N을 3으로 나누어가며 점점 작은 단위로 재귀함수를 호출하게 된다.
        * 이 때 (N/3)*(N/3) 정사각형의 번호를
        * 1 2 3
        * 4 5 6
        * 7 8 9
        * 위와 같이 매기고, cnt(int) 변수로 몇 번째 정사각형인지 확인한다.
        * 가운데 위치한 5번 사각형의 경우 star 함수를 호출하지 않고 다음 사각형으로 넘어간다.
        *
        * N==1인 경우 해당 좌표(matrix[x][y])에 '*'을 넣는다.
        * */

        if (N == 1) {
            matrix[x][y] = '*';
            return;
        }

        int cnt = 0;
        for (int i = x; i < x+N; i += N/3) {
            for (int j = y; j < y+N; j += N/3) {
                cnt ++;
                if (cnt == 5) {
                    continue;
                }
                star(N/3, i, j);
            }
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        /* N*N 크기의 2차원 배열 할당 후 공백(' ')으로 초기화 */
        matrix = new char[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(matrix[i], ' ');
        }

        star(N, 0, 0);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bw.write(matrix[i][j]);
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}