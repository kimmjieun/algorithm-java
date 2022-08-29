package 레벨2.다시풀문제;


import java.util.*;

class 하노이의탑_재귀 {
    ArrayList<int[]> seq = new ArrayList<>();

    public int[][] solution(int n) {
        hanoi(n, 1, 3, 2);

        int[][] answer = new int[seq.size()][2];
        for (int i = 0; i < seq.size(); ++i) {
            int[] cmd = seq.get(i);
            answer[i][0] = cmd[0];
            answer[i][1] = cmd[1];
        }

        return answer;
    }

    public void hanoi(int n, int from, int to, int via) {
        int[] move = {from, to};
        if (n == 1) {
            seq.add(move);
        } else {
            hanoi(n - 1, from, via, to);
            seq.add(move);
            hanoi(n - 1, via, to, from);
        }
    }
}