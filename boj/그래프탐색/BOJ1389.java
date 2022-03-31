package 그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1389 {
    public static int n;
    public static int[][] map;
    static final int INF = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new int[n + 1][n + 1];

        // 초기값 설정
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                map[i][j] = INF;
                if (i == j) {
                    map[i][j] = 0;
                }
            }
        }

        // 연결고리 표시
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = map[b][a] = 1;
        }


        for (int k = 1; k <= n; k++) { // 거쳐가는 노드
            for (int i = 1; i <= n; i++) { // 출발 노드
                for (int j = 1; j <= n; j++) { // 도착 노드
                    map[i][j] = Math.min(map[i][k] + map[k][j], map[i][j]);
//                    if (map[i][j] > map[i][k] + map[k][j]) {
//                        map[i][j] = map[i][k] + map[k][j];
//                    }
                }
            }
        }

//        for(int i=0;i<=n;i++){
//            for(int j=0;j<=n;j++){
//                System.out.print(map[i][j]+" ");
//            }
//            System.out.println();
//        }
        int res = INF;
        int idx = -1;

        // 케빈 베이컨의 수가 가장 작은 인덱스를 탐색
        for (int i = 1; i <= n; i++) {
            int total = 0;
            for (int j = 1; j <= n; j++) {
                total += map[i][j];
            }
            if (res > total) {
                res = total;
                idx = i;
            }
        }

        System.out.println(idx);


    }


}
