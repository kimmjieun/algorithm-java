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
        // value 기준 정렬
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<input.length;i++){
            map.put(i+1, input[N][i]); //점, 거리
        }

        // 맵을 리스트로 바꾸기
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());

        // 정렬하기
        Collections.sort(list, new Comparator<>(){
            @Override
            public int compare(Map.Entry<Integer,Integer> o1, Map.Entry<Integer,Integer> o2){
                return o1.getValue().compareTo(o2.getValue());
            }

        });
        System.out.println("오름차순");
        for(Map.Entry<Integer,Integer> entry :list){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }

    }
}


