package 레벨2.구현;

import java.util.*;

public class 점프와순간이동 {
    public int solution(int n) {
        int ans = 0;

        while (n != 0) {
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n -= 1;
                ans++;
            }
        }
        return ans;
    }
}
