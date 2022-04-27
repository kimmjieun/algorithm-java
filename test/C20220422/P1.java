import java.util.*;

// util java.io.*
class P1 {
    public String[] solution(String[] grades) {
        HashMap<String, Integer> score = new HashMap<>();
        score.put("A+", 1);
        score.put("A0", 2);
        score.put("A-", 3);
        score.put("B+", 4);
        score.put("B0", 5);
        score.put("B-", 6);
        score.put("C+", 7);
        score.put("C0", 8);
        score.put("C-", 9);
        score.put("D+", 10);
        score.put("D0", 11);
        score.put("D-", 12);
        score.put("F", 13);

        HashMap<Integer, String> score2 = new HashMap<>();
        score2.put(1, "A+");
        score2.put(2, "A0");
        score2.put(3, "A-");
        score2.put(4, "B+");
        score2.put(5, "B0");
        score2.put(6, "B-");
        score2.put(7, "C+");
        score2.put(8, "C0");
        score2.put(9, "C-");
        score2.put(10, "D+");
        score2.put(11, "D0");
        score2.put(12, "D-");
        score2.put(13, "F");


        List<String> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < grades.length; i++) {
            String[] s = grades[i].split(" ");
            String object = s[0];
            String grade = s[1];

            if (!list.contains(object)) {
                list.add(object);
                map.put(object, score.get(grade));
            } else {
                int ob = map.get(object);
                // 들어온 성적
                int nb = score.get(grade);
                if (ob > nb) { // 뉴비가 오비보다 작으면 교체//  작아야 성적 더 좋은 것
                    map.put(object, score.get(grade));
                } else if (ob == nb) {
                    continue;
                }
            }


        }

        ArrayList<Map.Entry<String, Integer>> result = new ArrayList<>(map.entrySet());
        Collections.sort(result, new Comparator<>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        String[] answer = new String[map.size()];
        int i = 0;
        for (Map.Entry<String, Integer> re : result) {
            answer[i++] = re.getKey() + " " + score2.get(re.getValue());
        }


        return answer;
    }
}

