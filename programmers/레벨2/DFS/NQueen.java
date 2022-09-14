package 레벨2.DFS;


class NQueen {
    int answer = 0;
    int[] arr;
    boolean[] visit;

    public int solution(int n) {
        arr = new int[n];
        visit = new boolean[n];
        back(0, n);
        return answer;
    }

    public void back(int depth, int n) {
        if (depth == n) {
            answer++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = i;
                if (check(depth)) back(depth + 1, n);
                visit[i] = false;
            }
        }
    }

    public boolean check(int idx) {  // 0~idx행의 값과 idx행의 값을 비교해서 같은게 있는지
        for (int i = 0; i < idx; i++) {// 왜 idx까지지?
            if (arr[idx] == arr[i]) return false;
            if (Math.abs(i - idx) == Math.abs(arr[i] - arr[idx])) return false;

        }
        return true;
    }

}
