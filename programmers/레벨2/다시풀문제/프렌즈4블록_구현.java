package 레벨2.다시풀문제;


import java.util.*;

class 프렌즈4블록_구현 {
    public int solution(int m, int n, String[] board) {
        int answer = 0;

        char[][] map = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = board[i].charAt(j);
            }
        }
        while (true) {
            // 1. 삭제할 블록 세기
            boolean[][] visit = new boolean[m][n];
            int block = 0;

            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (map[i][j] == '#') continue; // 이처리 안하면 시간초과
                    if (map[i][j] == map[i][j + 1] &&
                            map[i][j] == map[i + 1][j] &&
                            map[i][j] == map[i + 1][j + 1]) {
                        visit[i][j] = true;
                        visit[i + 1][j] = true;
                        visit[i][j + 1] = true;
                        visit[i + 1][j + 1] = true;

                    }
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (visit[i][j]) {
                        block++;
                        map[i][j] = '.';
                    }
                }
            }


            // 삭제할 블록이 없으면 반복문 종료
            if (block == 0) break;


            // 세로로 블록 제거
            for (int i = 0; i < n; i++) {
                Queue<Character> q = new LinkedList<>();
                for (int j = m - 1; j >= 0; j--) {
                    if (map[j][i] != '.') {
                        q.add(map[j][i]);
                    }
                }
                int idx = m - 1;
                // 삭제한 블록 위의 블록들 내리기
                while (!q.isEmpty()) {
                    map[idx--][i] = q.poll();
                }
                // 빈칸채우기
                for (int j = idx; j >= 0; j--) {
                    map[j][i] = '#';
                }
            }


            // 지워질 블록 저장
            answer += block;
        }

        return answer;
    }
}