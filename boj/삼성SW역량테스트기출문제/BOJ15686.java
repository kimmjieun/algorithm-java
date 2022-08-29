package 삼성SW역량테스트기출문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ15686 {
    static int n, m, map[][];
    static boolean[] visit;
    static ArrayList<int[]> home = new ArrayList<>();
    static ArrayList<int[]> chicken = new ArrayList<>();
    static ArrayList<Integer> choice = new ArrayList<>();
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    home.add(new int[]{i, j});
                } else if (map[i][j] == 2) {
                    chicken.add(new int[]{i, j});
                }
            }
        }
        visit = new boolean[chicken.size()];
        back(0, 0);
        System.out.println(min);

    }

    static void back(int depth, int idx) {
        if (depth == m) {
            int sum = 0;
            // 도시치킨거리 최솟값 구하기
            for (int[] h : home) {
                // 집마다 최소 거리 구해서 저장하기
                int min = Integer.MAX_VALUE;
                for (Integer index : choice) {
                    int dist = Math.abs(h[0] - chicken.get(index)[0]) + Math.abs(h[1] - chicken.get(index)[1]);
                    min = Math.min(dist, min);
                }

                sum += min;
            }
            min = Math.min(min, sum);
            return;


        }

        for (int i = idx; i < chicken.size(); i++) {
            if (!visit[i]) {
                visit[i] = true;
                choice.add(i);
                back(depth + 1, i + 1);
                choice.remove(choice.size() - 1);
                visit[i] = false;
            }
        }
    }
}
