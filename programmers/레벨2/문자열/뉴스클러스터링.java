package 레벨2.문자열;

import java.util.*;
import java.util.regex.Pattern; // 이걸 꼭 넣어줘야해

class 뉴스클러스터링 {
    public int solution(String str1, String str2) {
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        if (str1.equals(str2)) return 65536;

        String pattern = "[a-zA-Z]+";

        ArrayList<String> list1 = new ArrayList<>();
        for (int i = 0; i < str1.length() - 1; i++) {
            String tmp = str1.substring(i, i + 2);
            if (Pattern.matches(pattern, tmp)) {
                list1.add(tmp);
            }

        }
        //System.out.println(list1.toString());

        ArrayList<String> list2 = new ArrayList<>();
        for (int i = 0; i < str2.length() - 1; i++) {
            String tmp = str2.substring(i, i + 2);
            if (Pattern.matches(pattern, tmp)) {
                list2.add(tmp);
            }
        }
        // System.out.println(list2.toString());

        int total = list1.size() + list2.size();
        int kyo = 0;
        for (String s : list2) {
            if (list1.contains(s)) {
                kyo++;
                list1.remove(s);
            }
        }
        int hap = total - kyo;
        //System.out.println(kyo+" "+hap);

        // 유사도 구하기
        int answer = (int) ((double) (kyo) / (double) (hap) * 65536);
        //System.out.println(answer);

        return answer;
    }
}
