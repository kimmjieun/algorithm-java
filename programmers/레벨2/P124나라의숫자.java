package 레벨2;

import java.util.*;

public class P124나라의숫자 {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            int tmp = n % 3;

            if (tmp == 0) tmp = 4;
            sb.append(tmp);

            if (tmp == 0) {
                n = n / 3 - 1;
            } else {
                n = n / 3;
            }

        }

        return sb.reverse().toString();
    }
}
