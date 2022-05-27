package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14889 {
    static int n;
    static int[][] map;
    static int min = Integer.MAX_VALUE;
    static boolean[] visit;

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

        visit = new boolean[n];
        back(0, 0);
        System.out.println(min);


    }

    static void back(int idx, int depth) {
        if (depth == n/2) {
//            diff();
            diff2();
            return;
        }

        for (int i = idx; i < n; i++) { // 0과 idx 차이 내일 n과 m하면서 정립하기
            if (!visit[i]) {
                visit[i] = true;
                back(i + 1, depth + 1);
                visit[i] = false;
            }
        }
    }
    public static void diff() {
        int start=0;
        int link=0;
        for(int i=0;i<n-1;i++) {
            for(int j=i+1;j<n;j++) {
                if(visit[i] && visit[j]) {
                    start+=map[i][j];
                    start+=map[j][i];
                }
                if(!visit[i] && !visit[j]) {
                    link+=map[i][j];
                    link+=map[j][i];
                }
            }
        }
        min=Math.min(Math.abs(start- link),min);
    }

    static void diff2(){
        int[] arr = new int[n / 2]; // visit true인 배열
        int[] arr2 = new int[n / 2]; // visit false인 배열
        int j = 0, k = 0;
        for (int i = 0; i < n; i++) {
            if (visit[i]) {
                arr[j++] = i;
            } else {
                arr2[k++] = i;
            }
        }

        int s = start(arr);

        int l = link(arr2);

        min = Math.min(min, Math.abs(s - l));
    }

    private static int start(int[] start) {
        int sum = 0;
        for (int i = 0; i < start.length; i++) {
            for (int j = 0; j < start.length; j++) {
                if (i == j)
                    continue;
                int x = start[i];
                int y = start[j];
                sum += map[x][y];

            }
        }
        return sum;
    }

    private static int link(int[] link) {

        int sum = 0;
        for (int i = 0; i < link.length; i++) {
            for (int j = 0; j < link.length; j++) {
                if (i == j)
                    continue;
                int x = link[i];
                int y = link[j];
                sum += map[x][y];

            }
        }

        return sum;
    }

}
