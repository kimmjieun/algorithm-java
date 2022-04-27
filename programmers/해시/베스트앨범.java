package 해시;

import java.util.*;

public class 베스트앨범 {
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


    // Map Value 기준 정렬 방식 다름, 나머지 동일
    public int[] solution2(String[] genres, int[] plays) {

        // 해시맵에 장르별 플레이 횟수 중첩해서 더해주기
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }

        // 플레이 횟수기준을 정렬
        ArrayList<Map.Entry<String, Integer>> mapList = new ArrayList<>(map.entrySet());

        Collections.sort(mapList, new Comparator<>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        // 가장많은 플레이 횟수 재생 장르부터 첫번째 인덱스와 두번째 인덱스 고르고 정답배열에 넣기
        ArrayList<Integer> list = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : mapList) {
            // System.out.println(entry.getKey()+" "+ entry.getValue());
            String genre = entry.getKey();


            int max = 0;
            int first = -1;
            for (int i = 0; i < genres.length; i++) {
                if (genre.equals(genres[i]) && max < plays[i]) {
                    max = plays[i];
                    first = i;
                }
            }

            list.add(first);

            max = 0;
            int second = -1;
            for (int i = 0; i < genres.length; i++) {
                if (genre.equals(genres[i]) && max < plays[i] && first != i) {
                    max = plays[i];
                    second = i;
                }
            }

            if (second >= 0) list.add(second);

        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
