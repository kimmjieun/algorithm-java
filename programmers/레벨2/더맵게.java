package 레벨2;

import java.util.PriorityQueue;

public class 더맵게 {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(); // 선언
        for (int s : scoville) {
            q.add(s);
        }

        int answer = 0;
        while (q.peek() < K) {
            if (q.size() == 1) {
                return -1;
            }
            int x = q.poll();
            int y = q.poll();
            q.add(x + y * 2);
            answer++;

        }

        return answer;
    }
}
