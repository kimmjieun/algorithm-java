package 레벨2.다시풀문제;


class 배달_플로이드와샬_다익스트라 {
    // 다익스트라
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[][] map = new int[N + 1][N + 1];
        //무한대로초기화
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                if (i == j) {
                    continue;
                }
                map[i][j] = 500001;
            }
        }

        // 간선정보저장
        for (int i = 0; i < road.length; i++) {
            if (map[road[i][0]][road[i][1]] < road[i][2]) continue;
            map[road[i][0]][road[i][1]] = road[i][2];
            map[road[i][1]][road[i][0]] = road[i][2];
        }

        int[] dist = new int[N + 1];
        for (int i = 2; i <= N; i++) {
            dist[i] = (dist[i] == 0) ? 500001 : map[1][i];
        }

        boolean[] visit = new boolean[N + 1];
        visit[1] = true;

        for (int i = 1; i <= N - 1; i++) { // N-1번 반복
            int min_idx = 1;
            int min_value = 500001;
            for (int j = 2; j <= N; j++) {
                if (!visit[j] && dist[j] < min_value) {
                    min_value = dist[j];
                    min_idx = j;
                }
            }
            visit[min_idx] = true;

            // 거쳐가는게 더 빠른지 확인
            for (int j = 2; j <= N; j++) {
                if (dist[j] > dist[min_idx] + map[min_idx][j]) {
                    dist[j] = dist[min_idx] + map[min_idx][j];
                }
            }

        }

        // 결과 카운트
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) answer++;
        }

        return answer;
    }


    // 플로이드와샬
    public int solution2(int N, int[][] road, int K) {
        int answer = 0;

        int[][] map = new int[N][N];

        //모든 map값의 INF값을 넣는다.(플로이드 와샬 쓰기위해) map[정점][정점]은 0으로초기화
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (i == j) {
                    continue;
                }
                map[i][j] = 500001;
            }
        }


        for (int i = 0; i < road.length; i++) {
            if (map[road[i][0] - 1][road[i][1] - 1] < road[i][2]) continue;
            map[road[i][0] - 1][road[i][1] - 1] = road[i][2];
            map[road[i][1] - 1][road[i][0] - 1] = road[i][2];
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (map[j][k] > map[j][i] + map[i][k]) {
                        map[j][k] = map[j][i] + map[i][k];
                    }
                }
            }
        }

        for (int i = 0; i < map[0].length; i++) {
            if (map[0][i] <= K) answer++;
        }
        return answer;
    }
}