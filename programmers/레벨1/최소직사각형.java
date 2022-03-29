package 레벨1;

import java.util.*;

public class 최소직사각형 {
    public int solution(int[][] sizes) {
        int answer = 0;


        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] > sizes[i][1]) {
                int tmp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = tmp;
            }
        }

        int max0 = 0;
        int max1 = 0;
        for (int i = 0; i < sizes.length; i++) {
            max0 = Math.max(max0, sizes[i][0]);
            max1 = Math.max(max1, sizes[i][1]);

        }
        return max0 * max1;
    }
}
