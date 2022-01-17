package boj.기타;



import java.io.*;
import java.util.StringTokenizer;

public class boj_17070 {
    static int N;
    static int[][] map;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ans = 0;
        DFS(1, 2, 0);

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();


    }

    // x는 세로, y는 가로
    // direction이 0일 때는 파이프가 가로방향, 1일 때 세로 방향, 2일 때 대각성방향
    public static void DFS(int x, int y, int direction) {
        // 종료 조건
        if (x == N && y == N) {
            ans++;
            return;
        }

        switch (direction) {
            case 0://파이프가  가로 방향일 경우 , 갈 수 있는 경우는 동쪽과 대각선
                if (y + 1 <= N && map[x][y + 1] == 0) { // 동쪽
                    DFS(x, y + 1, 0);
                }
                break;
            case 1: //파이프가 세로 방향일 경우, 갈 수 있는 경우는 남쪽과 대각선
                if (x + 1 <= N && map[x + 1][y] == 0) { // 남쪽
                    DFS(x + 1, y, 1);
                }
                break;
            case 2: // 파이프가 대각선일 경우 동쪽, 남쪽, 대각선
                if (y + 1 <= N && map[x][y + 1] == 0) { // 동쪽
                    DFS(x, y + 1, 0);
                }
                if (x + 1 <= N && map[x + 1][y] == 0) { // 남쪽
                    DFS(x + 1, y, 1);
                }
                break;
        }
        // 파이프가 어떤 방향이든지, 대각선은 검사해서 가장 아래로 뺐음
        if (y + 1 <= N && x + 1 <= N && map[x][y + 1] == 0 && map[x + 1][y] == 0 && map[x + 1][y + 1] == 0) {
            DFS(x + 1, y + 1, 2);
        }
    }

}
