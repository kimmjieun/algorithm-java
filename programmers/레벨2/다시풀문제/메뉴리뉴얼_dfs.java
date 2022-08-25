package 레벨2.다시풀문제;

import java.util.*;

public class 메뉴리뉴얼_dfs {
    HashMap<String, Integer> map;

    public String[] solution(String[] orders, int[] course) {

        ArrayList<String> res = new ArrayList<>();
        // 1. orders 정렬
        for (int i = 0; i < orders.length; i++) {
            char[] ch = orders[i].toCharArray();
            Arrays.sort(ch);
            // orders[i] = Arrays.toString(ch);
            orders[i] = String.valueOf(ch);
        }

        // course당 가장 많은 주문 받은 조합 저장
        for (int i = 0; i < course.length; i++) {
            int max = Integer.MIN_VALUE;
            map = new HashMap<>(); // course 개수가 달라질 때마다 map 새로 생성

            for (int j = 0; j < orders.length; j++) {
                if (course[i] <= orders[j].length()) {
                    back(orders[j], "", 0, 0, course[i]);
                }

            }

            //최댓값 구하기
            for (Map.Entry<String, Integer> m : map.entrySet()) {
                max = Math.max(max, m.getValue());
            }

            // 최댓값을 지닌 메뉴 결과에 넣기
            for (Map.Entry<String, Integer> m : map.entrySet()) {
                if (max >= 2 && max == m.getValue()) {
                    res.add(m.getKey());
                }
            }

        }

        Collections.sort(res);
        String[] answer = new String[res.size()];
        res.toArray(answer);

        return answer;
    }

    public void back(String order, String s, int idx, int depth, int target) {
        if (depth == target) {
            map.put(s, map.getOrDefault(s, 0) + 1);
            return;
        }

        for (int i = idx; i < order.length(); i++) {
            back(order, s + order.charAt(i), i + 1, depth + 1, target);
        }
    }
}
