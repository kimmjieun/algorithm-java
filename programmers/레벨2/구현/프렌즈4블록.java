package 레벨2.구현;


import java.util.*;

class 프렌즈4블록 {
    public int solution(int m, int n, String[] board) {
        int answer = 0;

        char[][] map = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = board[i].charAt(j);
            }
        }

        while (true) {
            int cnt = 0;

            boolean[][] visit = new boolean[m][n];

            // 지울 블록 체크하기
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (map[i][j] == '#') continue;// 빈칸이면 무시
                    if (map[i][j] == map[i + 1][j] &&
                            map[i][j] == map[i][j + 1] &&
                            map[i][j] == map[i + 1][j + 1]) {
                        visit[i][j] = true;
                        visit[i + 1][j] = true;
                        visit[i][j + 1] = true;
                        visit[i + 1][j + 1] = true;
                    }
                }
            }
            // visit 개수 세기
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (visit[i][j]) cnt++;
                }
            }
            answer += cnt;
            if (cnt == 0) break;


            // 블록 아래로 내리기
            Queue<Character> q = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!visit[j][i]) {
                        q.add(map[j][i]);
                    }
                }

                int j;
                for (j = 0; j < m - q.size(); j++) {
                    map[j][i] = '#';
                }

                while (!q.isEmpty()) {
                    map[j++][i] = q.poll();
                }

            }
        }
        return answer;
    }
}
