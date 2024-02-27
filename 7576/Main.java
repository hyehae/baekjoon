import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static class Pair {
        int X, Y;

        public Pair(int X, int Y) {
            this.X = X;
            this.Y = Y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int m, n;
        m = Integer.parseInt(input[0]); // 가로 칸 수
        n = Integer.parseInt(input[1]); // 세로 칸 수

        // board 초기화
        int[][] board = new int[n][m];
        int unripe = 0;
        for(int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for(int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(input[j]);
                if(Integer.parseInt(input[j]) == 0) {
                    /* 안익은 토마토 개수 확인 */
                    unripe++;
                }
            }
        }

        Queue<Pair> q = new LinkedList<>();
        Queue<Pair> tempQ = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        int days = 0;
        boolean finish = true;

        // 모든 익은 토마토 위치를 큐에 넣기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1) {
                    vis[i][j] = true;
                    q.add(new Pair(i, j));
                }
            }
        }

        while(unripe != 0) { // 안익은 토마토가 없을 때까지 반복
            if (q.isEmpty()) {
                /* 안익은 토마토가 있는데 더 이상 큐에 넣을 토마토가 없는 경우
                *  == (토마토가 모두 익지 못하는 상황) */
                finish = false;
                System.out.println("-1");
                break;
            }

            while (!q.isEmpty()) {
                Pair cur = q.poll();
                for (int dir = 0; dir < 4; dir++) {
                    int nx = cur.X + dx[dir];
                    int ny = cur.Y + dy[dir];

                    if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                    if (!vis[nx][ny] && board[nx][ny] == 0) {
                        unripe--;
                        board[nx][ny] = 1;              // 안익은 토마토를 익은 상태로 변경
                        vis[nx][ny] = true;             // 방문 처리
                        tempQ.add(new Pair(nx, ny));    // q는 하루 치 토마토 탐색이 끝나면 빈 상태가 되어야 하기 때문에 tempQ에 저장
                    }
                }
            }

            /* tempQ에 있는 토마토를 q로 이동 */
            while (!tempQ.isEmpty()) {
                q.add(tempQ.poll());
            }

            days++;
        }

        if (finish) {
            System.out.println(days);
        }
    }
}
