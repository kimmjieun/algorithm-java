
class P3 {
    public int answer = 0;
    public boolean[] visit;

    public int solution(int k, int m) {
        visit = new boolean[k + 1];

        back(0, k, m, "");
        return answer;
    }

    public void back(int depth, int k, int m, String s) {
        if (depth == k) {
            int result = Integer.parseInt(s);
            if (result % m == 0)
                answer++;
            return;
        }
        for (int i = 1; i <= k; i++) {
            if (!visit[i]) {
                visit[i] = true;
                back(depth + 1, k, m, s + i);
                visit[i] = false;
            }
        }
    }
}


