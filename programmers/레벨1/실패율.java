package 레벨1;

import java.util.*;

public class 실패율 {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        double users = stages.length;
        List<double[]> fail_rate = new ArrayList<>();

        int count = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < stages.length; j++) {
                if (stages[j] == i) {
                    count++;
                }

            }
            if (count == 0) {
                fail_rate.add(new double[]{i, 0});
                continue;
            }
            fail_rate.add(new double[]{i, count / users});
            users -= count;
            count = 0;
        }
        fail_rate.sort((a, b) -> Double.compare(b[1], a[1]));

        for (int i = 0; i < fail_rate.size(); i++) {
            answer[i] = (int) fail_rate.get(i)[0];
        }

        return answer;
    }
}
