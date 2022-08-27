package 레벨2.다시풀문제;


class NQueen_dfs {
    boolean[] visit;
    int[] pick; // 뽑은 위치를 저장, 0번 인덱스는 첫번째 줄에서 퀸의 위치 의미
    int count;

    public int solution(int n) {
        visit = new boolean[n];
        pick = new int[n];
        count = 0;
        back(n, 0);
        return count;
    }

    public void back(int n, int idx) {
        if (n == idx) {
            count++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                pick[idx] = i;
                if (check(idx)) back(n, idx + 1);
                visit[i] = false;
            }
        }
    }

    public boolean check(int idx) {
        for (int i = 0; i < idx; i++) {
            if (pick[i] == pick[idx]) return false; // 같은 행에 퀸이 존재하면 false
            if (Math.abs(idx - i) == Math.abs(pick[idx] - pick[i])) return false;// 대각선에 퀸이 존재한다면 false
        }
        return true;
    }

}
