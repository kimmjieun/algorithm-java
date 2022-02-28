package 정렬;

import java.util.*;

public class pgs_가장큰수 {

    public String solution(int[] numbers) {
        String answer = "";
        // 문자열 리턴을 해줄 스트링 배열 생성
        String[] str = new String[numbers.length];

        // int 배열 String 배열로 변환
        for (int i = 0; i < numbers.length; i++) {
            str[i] = String.valueOf(numbers[i]);
        }

        // 내림차순 정렬
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return (b + a).compareTo(a + b);
                // 오름차순 정렬 (o1+o2).compareTo(o1+o2);
            }
        });

        // 0값이 중복일 경우 ex) 0,0,0
        // 답이 000이면 안되므로 첫번째값이 0이면 0을 리턴
        if (str[0].equals("0")) return "0";

        for (String s : str) answer += s;

        return answer;
    }
}
