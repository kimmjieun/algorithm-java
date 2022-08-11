package 레벨1.해시;

import java.util.*;

public class 신고결과받기 {

    public int[] solution(String[] id_list, String[] report, int k) {

        HashSet<String> set = new HashSet<>();
        HashMap<String, ArrayList<String>> map = new HashMap<>();// 신고당한사람, 신고한사람리스트
        HashMap<String, Integer> result = new HashMap<>();// id, 신고메일받을 횟수

        // map 채우기
        for (int i = 0; i < report.length; i++) {
            if (!set.contains(report[i])) {
                set.add(report[i]);
                String[] s = report[i].split(" ");
                if (!map.containsKey(s[1])) {
                    map.put(s[1], new ArrayList<>());
                }
                map.get(s[1]).add(s[0]);
            }
        }

        for (String key : map.keySet()) {
            if (map.get(key).size() >= k) {
                for (String li : map.get(key)) {
                    result.put(li, result.getOrDefault(li, 0) + 1);
                }
            }
        }

        // 결과 출력
        int[] answer = new int[id_list.length];
        for (int i = 0; i < answer.length; i++) {
            if (!result.containsKey(id_list[i])) {
                answer[i] = 0;
            } else {
                answer[i] = result.get(id_list[i]);
            }
        }

        return answer;
    }
}
