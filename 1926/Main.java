import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int X, Y;

    public Pair(int x, int y) {
        X = x;
        Y = y;
    }
}

public class Main {
    static int BFS(int[][] board, boolean[][] vis, Pair pair, int n, int m) {
            Queue<Pair> q = new LinkedList<>();
            int[] dx = {1, 0, -1, 0};
            int[] dy = {0, 1, 0, -1};
            int area = 0;

            vis[pair.X][pair.Y] = true;
            q.add(pair);

            while(!q.isEmpty()) {
                area++;
                Pair cur = q.poll();

                for(int dir = 0; dir < 4; dir++) {
                    int nx = cur.X + dx[dir];
                    int ny = cur.Y + dy[dir];

                    if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                    if(vis[nx][ny] || board[nx][ny] != 1) continue;
                    vis[nx][ny] = true;
                    q.add(new Pair(nx, ny));
                }
            }

            return area;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");

        int n, m;
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        int[][] board = new int[n][m];
        for(int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for(int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(input[j]);
            }
        }

        boolean[][] vis = new boolean[n][m];
        int cnt = 0;
        int maxArea = 0;

        for(int i = 0; i < n ; i++) {
            for(int j = 0; j < m ; j++) {
                if(!vis[i][j] && board[i][j] == 1) {
                    cnt++;
                    int curArea = BFS(board, vis, new Pair(i, j), n, m);
                    if(curArea > maxArea) {
                        maxArea = curArea;
                    }
                }
            }
        }

        System.out.println(cnt);
        System.out.println(maxArea);
    }
}
