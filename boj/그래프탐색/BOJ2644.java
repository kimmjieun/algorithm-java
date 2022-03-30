package 그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2644 {
    static int N, a, b, res = -1, dist[];
    static ArrayList<ArrayList<Integer>> relation = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());    // 전체 사람 수
        dist = new int[N + 1];    // 촌수

        for (int i = 0; i < N + 1; i++) {
            relation.add(new ArrayList<>());
        }
        Arrays.fill(dist, -1);

        st = new StringTokenizer(br.readLine());

        // a, b 의 촌수를 구해야 함
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(br.readLine());    // 관계의 개수
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int p = Integer.parseInt(st.nextToken());
            int ch = Integer.parseInt(st.nextToken());
            relation.get(p).add(ch);
            relation.get(ch).add(p);
        }


        Queue<Integer> q = new LinkedList<>();
        // a와 b의 촌수 찾아야하므로 a부터 출발
        dist[a] = 0;
        q.add(a);

        while (!q.isEmpty()) {
            // 확인할 사람 큐에서 빼기
            int now = q.poll();

            // 비교대상을 찾으면 촌수 저장
            if (now == b) {
                res = dist[now];
                break;
            }

            // 해당 사람과 관계있는 사람들 확인
            for (int tmp : relation.get(now)) {
                if (dist[tmp] != -1) continue; // 이미 촌수 확인한 사람이면 pass
                dist[tmp] = dist[now] + 1; // 다음 관계는 현재까지 촌수 +1
                q.add(tmp);
            }
        }
        System.out.println(res);
    }

}
