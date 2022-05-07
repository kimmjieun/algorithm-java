package E20220503;

import java.util.Arrays;
import java.util.HashMap;

public class P3 {

    public static void main(String[] args) {

        String s = "photo.jpg, Warsaw, 2013-09-05 14:08:15\n"
                + "john.png, London, 2015-06-20 15:13:22\n"
                + "myFriends.png, Warsaw, 2013-09-05 14:07:13\n"
                + "Eiffel.jpg, Paris, 2015-07-23 08:03:02\n"
                + "pisatower.jpg, Paris, 2015-07-22 23:59:59\n"
                + "BOB.jpg, London, 2015-08-05 00:02:03\n"
                + "notredame.png, Paris, 2015-09-01 12:00:00\n"
                + "me.jpg, Warsaw, 2013-09-06 15:40:22\n"
                + "a.png, Warsaw, 2016-02-13 13:33:50\n"
                + "b.jpg, Warsaw, 2016-01-02 15:12:22\n"
                + "c.jpg, Warsaw, 2016-01-02 14:34:30\n"
                + "d.jpg, Warsaw, 2016-01-02 15:15:01\n"
                + "e.jpg, Warsaw, 2016-01-02 09:49:09\n"
                + "f.jpg, Warsaw, 2016-01-02 10:55:32\n"
                + "g.jpg, Warsaw, 2016-02-29 22:13:11";
        System.out.println(solution(s));
    }

    public static String solution(String S) {

        S = S.replaceAll(",", "");
        String[] s = S.split("\n");
        String answer = "";

        String[][] str = new String[s.length][]; // 입력을 2차원 배열에 저장
        String[] check = new String[s.length]; // 도시를 저장
        String[] checknum = new String[s.length]; // 날짜를 저장
        long[] checksize = new long[s.length];

        Arrays.fill(check, "");
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length; i++) {
            str[i] = s[i].split(" ");
            check[i] = str[i][1]; // 도시를 저장한다.
//            System.out.println(check[i]);

            // 날짜를 Long으로 바꿨다
            checksize[i] = Long.parseLong(str[i][2].replaceAll("-", "") + str[i][3].replaceAll(":", ""));

            map.put(str[i][1], map.getOrDefault(str[i][1], 0) + 1); // 도시별 최대 개수 구하기
        }

        System.out.println(Arrays.toString(checksize)); // 새로 알게된거 Arrays.toString 굳이 반복문 안만들어도 이렇게 출력가능하다
        for (int i = 0; i < s.length; i++) {

            // 이걸 구현을 못했어
            int count = 1;
            for (int j = 0; j < s.length; j++) {
                if (check[j].equals(check[i])) { // 이중포문으로 기준 하나와 전체 비교하기 같을 때
                    if (checksize[i] > checksize[j]) { // 반복문을 돌릴 때마다 i기준으로 전체와 비교하면서 날짜가 크면 count++해서 사진옆에붙일 숫자를 각각 구함
                        count++;
                    }
                }
            }

            System.out.println(count);


            int num = map.get(str[i][1]);
            int size = 0;
            while (num != 0) {
                num /= 10;
                size++;
            } // 몇자리수 해줄건지 -내가생각했던 방식이긴함

            checknum[i] = String.format("%0" + size + "d", count); // String.format
        }

        for (int i = 0; i < check.length; i++) {
            answer += check[i] + checknum[i] + str[i][0].substring(str[i][0].indexOf(".")) + "\n";
        }

        return answer;

    }

}
