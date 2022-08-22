package 레벨2.다시풀문제;

import java.util.*;

public class 소수찾기_dfs {
    int answer = 0;
    List<Integer> list = new ArrayList<>();
    boolean[] visit;

    public int solution(String numbers) {
        for (int i = 1; i <= numbers.length(); i++) {
            visit = new boolean[numbers.length()];
            back(i, numbers, "");
        }
        return answer;
    }

    public void back(int target, String numbers, String tmp) {

        if (target == tmp.length()) {
            int num = Integer.parseInt(tmp);
            if (isPrime(num) && !list.contains(num)) {
                list.add(num);
                answer++;
            }
            return;
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!visit[i]) {
                visit[i] = true;
                tmp += numbers.charAt(i);
                back(target, numbers, tmp);
                tmp = tmp.substring(0, tmp.length() - 1);
                visit[i] = false;
            }
        }
    }

    public boolean isPrime(int n) {
        if (n == 0 || n == 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
