package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10971 {
    static int n;
    static int[][] map;
    static boolean[] visit;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());


        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        answer = Integer.MAX_VALUE;
        visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            visit[i] = true;
            back(i, i, 0, 0);
        }
        System.out.println(answer);

    }

    public static void back(int start, int now, int sum, int cnt) {
        if (cnt == n - 1) { // 모든 노드 방문한 경우 n-1이 맞다 , 처음 노드는 위에서 방문했기에
            // 마지막노드에서 맨처음 노드로 가는 비용 더하기
            if (map[now][start] != 0) {
                sum += map[now][start];
//                if(sum<answer) answer = sum; //??? 있고 없고 차이가 뭘까
                answer = Math.min(answer, sum);
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visit[i] && map[now][i] != 0) {
                visit[i] = true;
                back(start, i, sum + map[now][i], cnt + 1);
                visit[i] = false;
            }

        }
    }
}
