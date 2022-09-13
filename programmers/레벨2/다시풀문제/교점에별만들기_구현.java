package 레벨2.다시풀문제;


import java.util.*;

class 교점에별만들기_구현 {
    public String[] solution(int[][] line) {
        long maxX = Long.MIN_VALUE;
        long maxY = Long.MIN_VALUE;
        long minX = Long.MAX_VALUE;
        long minY = Long.MAX_VALUE;
        // 교점계산하기
        Queue<String> q = new LinkedList<>();
        //  교점 구하기
        for (int i = 0; i < line.length; i++) {
            for (int j = 0; j < line.length; j++) {
                if (i == j) continue;

                long a = line[i][0];
                long b = line[i][1];
                long e = line[i][2];
                long c = line[j][0];
                long d = line[j][1];
                long f = line[j][2];


                long adbc = a * d - b * c;
                if (adbc == 0) continue; //비교대상 직선과 평행함

                long bfed = b * f - e * d;
                if (bfed % adbc != 0) continue; //x가 정수가 아님

                long ecaf = e * c - a * f;
                if (ecaf % adbc != 0) continue; //y가 정수가 아님

                long nx = bfed / adbc;
                long ny = ecaf / adbc;
                q.add(nx + " " + ny);

                maxX = Math.max(nx, maxX);
                maxY = Math.max(ny, maxY);
                minX = Math.min(nx, minX);
                minY = Math.min(ny, minY);

            }

        }

        String[] answer = {};
        long height = maxY - minY + 1;
        long width = maxX - minX + 1;
        answer = new String[(int) height];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < width; i++) {
            sb.append(".");
        }

        Arrays.fill(answer, sb.toString());

        long nx, ny;
        while (!q.isEmpty()) {

            String[] t = q.poll().split(" ");

            ny = maxY - Long.parseLong(t[1]);
            nx = Long.parseLong(t[0]) - minX;
            answer[(int) ny] = answer[(int) ny].substring(0, (int) nx) + "*"
                    + answer[(int) ny].substring((int) nx + 1);
        }


        return answer;
    }
}