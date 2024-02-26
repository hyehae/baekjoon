import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int X, Y;

    public Pair(int X, int Y) {
        this.X = X;
        this.Y = Y;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N, M 입력
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        // 미로 입력 받아 이차원 배열에 저장
        String[] boardInput = new String[N];
        for(int i=0; i<N; i++) {
            boardInput[i] = br.readLine();
        }

        int[][] board = new int[N][M];
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                board[i][j] = (int)boardInput[i].charAt(j)-'0';
            }
        }

        // BFS에 필요한 것
        int[][] dist = new int[N][M];
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                dist[i][j] = -1;
            }
        }

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        Queue<Pair> Q = new LinkedList<>();

        // 첫번째 칸 방문 칸 수에 추가 && 큐에 삽입
        dist[0][0] = 1;
        Q.add(new Pair(0, 0));

        // 큐가 빌 때까지 반복
        while(!Q.isEmpty()) {
            Pair cur = Q.poll();

            for(int dir = 0; dir < 4; dir++) {
                int nx = cur.X + dx[dir];
                int ny = cur.Y + dy[dir];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M)
                    continue;
                if(dist[nx][ny] >= 0 || board[nx][ny] != 1)
                    continue;

                dist[nx][ny] = dist[cur.X][cur.Y]+1;
                Q.add(new Pair(nx, ny));
            }
        }

        System.out.println(dist[N-1][M-1]);
    }
}
