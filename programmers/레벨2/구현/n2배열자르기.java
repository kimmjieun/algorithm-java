package 레벨2.구현;

import java.util.*;

public class n2배열자르기 {
    public int[][] map;
    public int[] dx = {0, 1, 1};
    public int[] dy = {1, 0, 1};
    public Queue<int[]> q = new LinkedList<>();

    public int[] solution(int n, long left, long right) {

        //bfs(n); // 이렇게 하면 시간초과

        int[] answer = new int[(int) (right - left) + 1];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = Math.max((int) ((left + i) / n), (int) ((left + i) % n)) + 1;
        }

        return answer;
    }


    public void bfs(int n) {
        map[0][0] = 1;
        q.add(new int[]{0, 0});
        while (!q.isEmpty()) {
            int[] t = q.poll();
            for (int i = 0; i < 3; i++) {
                int nx = dx[i] + t[0];
                int ny = dy[i] + t[1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (map[nx][ny] == 0) {
                        q.add(new int[]{nx, ny});
                        map[nx][ny] = map[t[0]][t[1]] + 1;
                    }
                }
            }
        }
    }
}
