package 레벨1.쉬운문제;

import java.util.Arrays;

public class 예산 {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        int sum = 0;
        for (int i = 0; i < d.length; i++) {
            sum += d[i];
            answer++;
            if (sum == budget) break;
            if (sum > budget) {
                answer--;
                break;
            }
        }
        return answer;
    }
}
