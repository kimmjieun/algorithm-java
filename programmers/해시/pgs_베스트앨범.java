package 해시;

import java.util.*;

public class pgs_베스트앨범 {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }

        // key 값만 가져와서 genre에 넣어주기
        ArrayList<String> genre = new ArrayList<>();
        for (String key : map.keySet()) {
            genre.add(key);
        }

        // key 값에 해당하는 value를 내림차순으로 정렬
        Collections.sort(genre, (o1, o2) -> map.get(o2) - map.get(o1));

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < genre.size(); i++) {
            String g = genre.get(i);

            // 해당 장르의 음악중에서 play 횟수가 가장 큰 인덱스를 찾는다
            int max = 0;
            int firstIdx = -1;
            for (int j = 0; j < genres.length; j++) {
                if (g.equals(genres[j]) && max < plays[j]) {
                    max = plays[j];
                    firstIdx = j;
                }
            }

            // 해당 장르의 음악 중에서 play 횟수가 두번째로 큰 인덱스를 찾는다
            max = 0;
            int secondIdx = -1;
            for (int j = 0; j < genres.length; j++) {
                if (g.equals(genres[j]) && max < plays[j] && j != firstIdx) {
                    max = plays[j];
                    secondIdx = j;
                }
            }

            list.add(firstIdx);
            if (secondIdx >= 0) list.add(secondIdx); // secondIdx는 존재할 수도, 안할 수 도 있다


        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}
