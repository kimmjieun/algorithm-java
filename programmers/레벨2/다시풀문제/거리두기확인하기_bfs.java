package 레벨2.다시풀문제;

import java.util.*;

public class 거리두기확인하기_bfs {
    public int[] dx = {-1, 1, 0, 0};
    public int[] dy = {0, 0, -1, 1};

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for (int i = 0; i < places.length; i++) {
            answer[i] = isCorrect(places[i]);
        }

        return answer;
    }

    public int isCorrect(String[] place) {
        for (int i = 0; i < place.length; i++) {
            for (int j = 0; j < place[i].length(); j++) {
                if (place[i].charAt(j) == 'P') { // 요깅
                    if (!bfs(place, i, j)) return 0;
                }
            }
        }

        return 1;
    }

    public boolean bfs(String[] place, int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});

        boolean[][] visit = new boolean[place.length][place.length];
        visit[x][y] = true;
        while (!q.isEmpty()) {
            int[] t = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = t[0] + dx[i];
                int ny = t[1] + dy[i];
                int dist = Math.abs(x - nx) + Math.abs(y - ny);

                if (nx < 0 || ny < 0 || nx >= place.length || ny >= place.length) continue;
                if (dist > 2 || visit[nx][ny]) continue;

                visit[nx][ny] = true; //요거
                if (place[nx].charAt(ny) == 'X') continue;
                else if (place[nx].charAt(ny) == 'P') return false;
                else q.add(new int[]{nx, ny});

            }

        }
        return true;
    }

}
