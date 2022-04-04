package DM20220402;

import java.util.*;

public class P1 {
    public static void solution(int[][] input) {
        int I = 0, J = 0;
        int max = 0;
        // 제일 먼 거리 구하기
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {
                if (input[i][j] > max) {
                    max = input[i][j];
                    I = i;
                    J = j;
                }
            }
        }

        solve(I, input);
        solve(J, input);

    }

    public static void main(String[] args) {
        int[][] input = {{0, 5, 2, 4, 1}, {5, 0, 3, 9, 6}, {2, 3, 0, 6, 3}, {4, 9, 6, 0, 3}, {1, 6, 3, 3, 0}};
        solution(input);
    }

    public static void solve(int N, int[][] input) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < input.length; i++) {
            map.put(i + 1, input[N][i]); // 번호, 거리
        }

        // Map.Entry 리스트 작성
        List<Map.Entry<Integer, Integer>> list_entries = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());

        // 비교함수 Comparator를 사용하여 오름차순으로 정렬
        Collections.sort(list_entries, new Comparator<Map.Entry<Integer, Integer>>() {
            // compare로 값을 비교
            public int compare(Map.Entry<Integer, Integer> obj1, Map.Entry<Integer, Integer> obj2) {
                // 오름 차순 정렬
                return obj1.getValue().compareTo(obj2.getValue());
            }
        });

        System.out.println("오름차순 정렬");
        // 결과 출력
        for (Map.Entry<Integer, Integer> entry : list_entries) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}

