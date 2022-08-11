package 레벨1.문자열;

import java.util.*;

public class 문자열내림차순으로배치하기 {
    public String solution(String s) {
        String answer = "";

        String[] str = new String[s.length()];
        for (int i = 0; i < s.length(); i++) {
            str[i] = s.charAt(i) + "";
        }
        Arrays.sort(str);
        for (int i = s.length() - 1; i >= 0; i--) {
            answer += str[i];
        }

        // 큰것부터 작은 것 정렬
        return answer;
    }

}
