package 레벨2.다시풀문제;

import java.util.*;

public class 소수찾기 {
    int answer = 0;
    boolean[] visit;
    ArrayList<Integer> list = new ArrayList<>();

    public int solution(String numbers) {
        for (int i = 1; i <= numbers.length(); i++) {
            visit = new boolean[numbers.length()];
            back(i, 0, "", numbers);
        }
        return answer;
    }

    public void back(int target, int depth, String str, String numbers) {
        if (target == depth) {
            int n = Integer.parseInt(str);
            if (!list.contains(n)) {
                if (isPrime(n)) {
                    list.add(n);
                    answer++;
                }
            }
            return;
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!visit[i]) {
                visit[i] = true;
                back(target, depth + 1, str + numbers.charAt(i), numbers);
                visit[i] = false;
            }
        }
    }


    public boolean isPrime(int n) {
        if (n == 0 || n == 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}
