package 레벨2.다시풀문제;


import java.util.*;

class 두큐합같게만들기_그리디 {

    public int solution(int[] queue1, int[] queue2) {
        int answer = -2;
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        long s1 = 0, s2 = 0;
        for (int tmp : queue1) {
            q1.add(tmp);
            s1 += tmp;
        }
        for (int tmp : queue2) {
            q2.add(tmp);
            s2 += tmp;
        }
        long sum = s1 + s2;
        if (sum % 2 == 1) return -1;
        int p1 = 0, p2 = 0, limit = queue1.length * 2;

        while (p1 <= limit && p2 <= limit) {
            if (s1 == sum / 2) return p1 + p2;
            if (s1 > sum / 2) {
                s1 -= q1.peek();
                s2 += q1.peek();
                p1++;
                q2.add(q1.poll());
            } else {
                s1 += q2.peek();
                s2 -= q2.peek();
                p2++;
                q1.add(q2.poll());
            }
        }


        return -1;
    }
}