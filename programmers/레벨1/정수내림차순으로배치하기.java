package 레벨1;

import java.util.*;

public class 정수내림차순으로배치하기 {
    public long solution(long n) {
        long answer = 0;
        String s = String.valueOf(n);
        char[] c = s.toCharArray();

        Arrays.sort(c);


        String tmp = "";
        for (int i = c.length - 1; i >= 0; i--) {
            tmp += c[i];
        }
        answer = Long.parseLong(tmp);
        return answer;
    }
}
