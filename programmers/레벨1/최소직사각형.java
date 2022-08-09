package 레벨1;

import java.util.*;

public class 최소직사각형 {
    public int solution(int[][] sizes) {
        int answer = 0;

        int maxX = 0;
        int maxY = 0;
        for (int i = 0; i < sizes.length; i++) {
            // 가로가 작은거 세로가 큰거
            if (sizes[i][0] >= sizes[i][1]) {
                maxX = Math.max(maxX, sizes[i][1]);
                maxY = Math.max(maxY, sizes[i][0]);
            } else {
                maxX = Math.max(maxX, sizes[i][0]);
                maxY = Math.max(maxY, sizes[i][1]);
            }
            //System.out.println(sizes[i][0]+" "+sizes[i][1]);

        }
        return maxX * maxY;
    }
}
