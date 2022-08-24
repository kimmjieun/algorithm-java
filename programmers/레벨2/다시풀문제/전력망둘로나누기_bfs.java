package 레벨2.다시풀문제;


import java.util.*;

class 전력망둘로나누기_bfs {
    public int[][] map;


    public int solution(int n, int[][] wires) {
        int answer = n;
        map = new int[n + 1][n + 1];

        //1. 인접행렬에 input
        for (int i = 0; i < wires.length; i++) {
            map[wires[i][0]][wires[i][1]] = 1;
            map[wires[i][1]][wires[i][0]] = 1;
        }

        //2. 선을 하나씩 끊어보며 순회
        int a, b;
        for (int i = 0; i < wires.length; i++) {
            a = wires[i][0];
            b = wires[i][1];

            //선을 하나 끊고
            map[a][b] = 0;
            map[b][a] = 0;

            //bfs
            answer = Math.min(answer, bfs(n, a));

            //선 다시 복구
            map[a][b] = 1;
            map[b][a] = 1;
        }

        return answer;
    }

    public int bfs(int n, int start) {
        int[] visit = new int[n + 1];
        int cnt = 1;
        Queue<Integer> q = new LinkedList<>();

        q.add(start);


        while (!q.isEmpty()) {
            int x = q.poll();
            visit[x] = 1;
            for (int i = 1; i <= n; i++) {
                if (visit[i] == 1) continue;
                if (map[x][i] == 1) {
                    q.add(i);
                    cnt++;
                }
            }
        }
        return (int) Math.abs(n - 2 * cnt);//cnt-(n-cnt)
    }
}
