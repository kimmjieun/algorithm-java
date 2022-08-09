package 레벨1;

import java.util.*;

public class 문자열내마음대로정렬하기 {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];

        Arrays.sort(strings, new Comparator<>() {
            @Override
            public int compare(String o1, String o2) {

                if (o1.charAt(n) == o2.charAt(n)) {
                    return o1.compareTo(o2);
                }
                return o1.charAt(n) - o2.charAt(n);
            }
        });


        for (int i = 0; i < answer.length; i++) {
            answer[i] = strings[i];
        }
        return answer;
    }
}
