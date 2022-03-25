package 레벨1;

import java.util.*;

public class 실패율 {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        List<double[]> failRate = new ArrayList<>();

        double sum = stages.length;

        for (int i = 1; i <= N; i++) {
            int cnt = 0;
            for (int j = 0; j < stages.length; j++) {
                if (stages[j] == i) {
                    cnt++;
                }
            }

            if (cnt == 0) {
                failRate.add(new double[]{i, 0});
            } else {
                failRate.add(new double[]{i, cnt / sum});
            }
            sum -= cnt;
        }

        Collections.sort(failRate, ((o1, o2) -> Double.compare(o2[1], o1[1])));


        for (int i = 0; i < failRate.size(); i++) {
            answer[i] = (int) failRate.get(i)[0];
        }
        return answer;
    }

}
