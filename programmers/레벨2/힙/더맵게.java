package 레벨2.힙;

import java.util.*;

public class 더맵게 {
    public int solution(int[] scoville, int K) {

        int answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int s : scoville) {
            q.add(s);
        }

        while (q.peek() < K) {
            // 모든 음식 스코빌 지수를 k 이상으로 만들 수 없는 경우 -1
            if (answer == scoville.length - 1) return -1;
            int a = q.poll();
            int b = q.poll();
            q.add(a + (b * 2));
            answer++;
        }
        return answer;
    }
}
