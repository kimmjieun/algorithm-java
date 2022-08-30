package 레벨2.다시풀문제;


import java.util.*;

class 숫자블록_수학 {
    public int[] solution(long begin, long end) {


        List<Integer> board = new ArrayList<>();
        int length = (int) (end - begin + 1);
        int[] answer = new int[length];

        for (long i = begin; i <= end; i++) {
            if (i == 1) {
                board.add(0);
                continue;
            } else {
                board.add((int) block(i));
            }

        }

        for (int i = 0; i < board.size(); i++) {
            answer[i] = board.get(i);
        }
        return answer;
    }

    // 에러토스테네스의 체
    public long block(long n) {
        for (long i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                if (n / i > 10000000) continue;

                return n / i;
            }
        }
        return 1;
    }

}
