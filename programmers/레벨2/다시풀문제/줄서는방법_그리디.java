package 레벨2.다시풀문제;


import java.util.*;

// 효율성 틀림, 다시 풀어봐야함
class 줄서는방법_그리디 {
    public int[] answer;
    public boolean[] visit;
    public int count = 0;
    public ArrayList<Integer> list = new ArrayList<>();

    public int[] solution(int n, long k) {
        answer = new int[n];
        visit = new boolean[n + 1];
        back(n, k, 0);
        return answer;
    }

    public void back(int n, long k, int depth) {
        if (depth == n) {
            count++;
            if (count == k) {
                for (int i = 0; i < n; i++) {
                    answer[i] = list.get(i);
                }
                //System.out.println(list.toString());
                // list.toArray(new int[n]); // 왜
            }
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                list.add(i);
                back(n, k, depth + 1);
                list.remove(list.size() - 1);
                visit[i] = false;
            }

        }
    }
}
