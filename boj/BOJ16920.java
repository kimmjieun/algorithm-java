import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ16920 {
    static int n, m, p, player[];
    static int map[][];
    static Queue<int[]> q[];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());

        q = new LinkedList[p + 1];
        for (int i = 1; i <= p; i++){
            q[i] = new LinkedList<>();
        }

        player = new int[p + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= p; i++) {
            player[i] = Integer.parseInt(st.nextToken());
        }

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String ss = br.readLine();
            for (int j = 0; j < m; j++) {
                char ch = ss.charAt(j);
                if (ch >= '1' && ch <= '9') {
                    map[i][j] = ch - '0';
                    q[map[i][j]].add(new int[]{i, j});// 플레이어마다 좌표값 저장
                } else if (ch == '#') map[i][j] = -1; // 벽일때 -1

                if (map[i][j] == '.') map[i][j] = 0; // 빈칸일 때 0

            }
        }


        while (true) {
            // 플레이어 큐 비면 종료
            int cnt = 0;
            for (int i = 1; i <= p; i++) {
                if (q[i].size() == 0) cnt++;
            }
            if (cnt == p) {
                break;
            }

            // 플레이어
            for (int i = 1; i <= p; i++) {
                for (int play = 0; play < player[i]; play++) { // 플레이어 이동할 수 있는 칸수
                    int qsize = q[i].size();
                    if (qsize == 0) break;
                    while (qsize-- > 0) {
                        int[] t = q[i].poll();
                        for (int d = 0; d < 4; d++) {
                            int nx = dx[d] + t[0];
                            int ny = dy[d] + t[1];
                            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                                if (map[nx][ny] == 0) {
                                    q[i].add(new int[]{nx, ny});
                                    map[nx][ny] = i;
                                }
                            }

                        }

                    }
                }
            }
        }

        int rst[] = new int[p + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] >= 1 && map[i][j] <= 9)
                    rst[map[i][j]]++;
            }
        }
        for (int i = 1; i <= p; i++) {
            System.out.print(rst[i] + " ");
        }


    }
}
