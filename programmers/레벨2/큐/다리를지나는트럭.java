package 레벨2.큐;

import java.util.*;

public class 다리를지나는트럭 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int sum = 0;

        Queue<Integer> q = new LinkedList<>();// 다리 = 큐
        for (Integer truck : truck_weights) {
            while (true) {
                if (q.isEmpty()) { // 큐가 비었을 때
                    // 다리에 트럭 올린다
                    time++;
                    sum += truck;
                    q.add(truck);
                    break;
                } else if (q.size() == bridge_length) { // 큐 사이즈와 다리 길이 일치할 때
                    // 트럭 다리를 지나도록 한다.
                    sum -= q.poll();
                } else {// 큐사이즈가 다리길이가 일치하지 않을 때 다리 채우기

                    if (sum + truck <= weight) { // 다리 최대 무게에 도달하지 않았을 때
                        // 다리에 트럭 올린다
                        time++;
                        sum += truck;
                        q.add(truck);
                        break;

                    } else { // 최대 무게 초과할 때
                        q.add(0); // 큐사이즈를 늘려서 트럭이 다음 턴에서 다리를 지나도록 한다.
                        time++;
                    }

                }
            }

        }
        // 마지막 트럭에서 반복문 끝나는데, 마지막 역시 다리 길이만큼 지나가야기에 + 다리길이
        return time + bridge_length;

    }


}
