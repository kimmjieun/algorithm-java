package 레벨1;

import java.util.*;

public class 실패율 {
    public int[] solution(int N, int[] stages) {

        HashMap<Integer, Integer> map = new HashMap<>(); // 스테이지당 실패한 사람수 저장
        HashMap<Integer, Double> map2 = new HashMap<>(); // 스테이지당 실패율 저장

        for (int i = 1; i <= N; i++) {
            map.put(i, 0);
        }

        for (int s : stages) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            }
        }

        int len = stages.length;
        for (int i = 1; i <= N; i++) {
            // 추가
            if (len == 0) {
                map2.put(i, 0.0);
                continue;
            }
            map2.put(i, (double) map.get(i) / (double) len);
            len -= map.get(i);
        }

        // value로 정렬
        ArrayList<Map.Entry<Integer, Double>> list = new ArrayList<>(map2.entrySet());
        Collections.sort(list, new Comparator<>() {
            @Override
            public int compare(Map.Entry<Integer, Double> o1, Map.Entry<Integer, Double> o2) {
                if (Double.compare(o1.getValue(), o2.getValue()) == 0) {
                    return o1.getKey().compareTo(o2.getKey());
                }
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        int[] answer = new int[N];
        int i = 0;
        for (Map.Entry<Integer, Double> m : list) {
            answer[i++] = m.getKey();
        }

        return answer;
    }

}
