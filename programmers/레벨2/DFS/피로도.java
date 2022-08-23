package 레벨2.DFS;


import java.util.*;

class 피로도 {
    public int answer = 0;
    public boolean[] visit;
    public ArrayList<Integer> list = new ArrayList<>();

    public int solution(int k, int[][] dungeons) {
        visit = new boolean[dungeons.length];
        back(0, k, dungeons);
        return answer;
    }

    public void back(int depth, int k, int[][] dungeons) {
        if (depth == dungeons.length) {
            int cnt = 0;
            for (int idx : list) {
                if (k >= dungeons[idx][0]) {
                    k -= dungeons[idx][1];
                    cnt++;
                } else {
                    break;
                }
            }
            answer = Math.max(cnt, answer);
            return;
        }

        for (int i = 0; i < dungeons.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                list.add(i);
                back(depth + 1, k, dungeons);
                list.remove(list.size() - 1);
                visit[i] = false;
            }
        }
    }
}
