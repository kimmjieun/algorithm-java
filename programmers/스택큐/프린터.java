package 스택큐;

import java.util.*;

public class 프린터 {
    public int solution(int[] priorities, int location) {
        int answer = 1; // 출력순서. 몇번째로 출력되는가 ?

        // 우선순위 큐에 문서 우선순위 저장 (우선순위 내림차순 정렬)
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int priority : priorities) {
            pq.add(priority);
        }

        // 우선순위 높은 순으로 기존 배열에서 일치하는 문서 찾기
        while (!pq.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (pq.peek() == priorities[i]) {
                    // 우선순이ㅜ큐에서 읽은 요소가 location에 위치한 요소일 경우 출력순서리턴
                    if (i == location)
                        return answer;
                    answer++;
                    pq.poll(); // 값을 찾았을 때만 큐에서 빼야함
                }
            }
        }

        return answer;
    }
}
