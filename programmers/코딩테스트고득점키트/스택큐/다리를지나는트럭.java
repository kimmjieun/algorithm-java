package 코딩테스트고득점키트.스택큐;

import java.util.*;

public class 다리를지나는트럭 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        Queue<Integer> q = new LinkedList<>();

        int sum = 0;
        for (int truck : truck_weights) {
            while (true) {
                // 큐에 아무것도 없는 경우 = 어떠한 트럭도 다리 위에 없음
                if (q.isEmpty()) {
                    q.add(truck);
                    time++;  // 다리에 오를 때만 시간 추가
                    sum += truck;
                    break;
                } else if (q.size() == bridge_length) { // 큐에 다리 길이 만큼 트럭 다 찬 경우
                    sum -= q.poll();
                } else { // 다리 길이 만큼 큐가 찾지 않았음
                    if (sum + truck > weight) {
                        // 넘는다면 0을 넣어 이미 큐에 있는 다리를 건너게 만듬
                        q.add(0);
                        time++;
                    } else { // weight 값을 넘지 않는 선에서 새로운 트럭을 다리에 올려줌
                        q.add(truck);
                        sum += truck;
                        time++;
                        break;
                    }
                }

            }
        }
        // 마지막 트럭에서 반복문 끝나는데 마지막 역시 다리 길이만큼 지나가야하기에 + 다리길이
        return time + bridge_length;
    }
}
