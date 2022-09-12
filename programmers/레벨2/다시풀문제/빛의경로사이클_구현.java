package 레벨2.다시풀문제;


import java.util.*;

class 빛의경로사이클_구현 {
    int R, C;
    int[] dr = {1, 0, -1, 0};// 아래 왼 위 오른 시계
    int[] dc = {0, -1, 0, 1};
    boolean[][][] visit;

    public int[] solution(String[] grid) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        R = grid.length;
        C = grid[0].length();
        visit = new boolean[R][C][4];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                for (int d = 0; d < 4; d++) {
                    if (!visit[i][j][d]) {
                        list.add(light(grid, i, j, d));
                    }
                }
            }
        }

        Collections.sort(list);
        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    public int light(String[] grid, int r, int c, int d) {
        int cnt = 0;
        while (true) {
            if (visit[r][c][d]) break;

            cnt++;
            visit[r][c][d] = true;// 방문처리

            // L 반시계, R 시계
            if (grid[r].charAt(c) == 'L')
                d = d == 0 ? 3 : d - 1;// 좌회전
            else if (grid[r].charAt(c) == 'R')
                d = d == 3 ? 0 : d + 1;

            r = (r + dr[d] + R) % R;
            c = (c + dc[d] + C) % C;
        }
        return cnt;
    }
}